import time
from machine import I2C, Pin
import machine
import utime
import sys, os
import select

from pico.neopixel import Neopixel

_ADDR = 0x5B

values = {
    "co2": 0,
    "tVOC": 0,
    "temperature": 0.0,
    "humidity": 0.0,
}

thresholds = {
    "co2": 1000,
    "tVOC": 500,
}

class CCS811:
    def __init__(self, i2c: I2C):
        self._i2c = i2c

    def setup(self):
        print("setup CCS811")
        self.multi_write_register(0xFF, b"\x11\xE5\x72\x8A")  # RESET
        time.sleep_ms(100)

        self.check_for_status_error()
        self.app_valid()

        self._i2c.writeto_mem(_ADDR, 0xF4, b"")  # APP_START
        time.sleep_ms(100)
        self.set_driver_mode(1)
        time.sleep_ms(100)

    def data_available(self) -> bool:
        v = self._i2c.readfrom_mem(_ADDR, 0x00, 1)
        if v[0] & 1:
            e = self.read_register(0xE0)
            print("error register", hex(e[0]))
        return (v[0] & 1 << 3) > 0

    def check_for_status_error(self) -> bool:
        v = self.read_register(0x00)
        return (v[0] & 1 << 0) > 0

    def app_valid(self):
        v = self.read_register(0x00)
        return (v[0] & 1 << 4) > 0

    def set_driver_mode(self, mode: int):
        v = self.read_register(0x01)  # MEAS_MODE
        v = v[0]
        v &= ~(0b00000111 << 4)  # Clear DRIVE_MODE bits
        v |= mode << 4  # Mask in mode
        self.write_register(0x01, v)

    def read_algorithm_results(self):
        v = self.multi_read_register(0x02, 4)  # ALG_RESULT_DATA
        co2 = v[0] << 8 | v[1]
        t_voc = v[2] << 8 | v[3]
        return co2, t_voc

    def write_register(self, offset: int, value: int):
        return self._i2c.writeto_mem(_ADDR, offset, bytes([value]))

    def read_register(self, offset: int):
        return self._i2c.readfrom_mem(_ADDR, offset, 1)

    def multi_write_register(self, offset: int, data: bytes):
        self._i2c.writeto_mem(_ADDR, offset, data)

    def multi_read_register(self, offset: int, length: int):
        return self._i2c.readfrom_mem(_ADDR, offset, length)

    def status(self):
        b = self._i2c.readfrom(_ADDR, 1)
        return b[0]

class DHT11:
    def __init__(self, pin):
        self.pin = machine.Pin(pin, machine.Pin.OUT)
        self.pin.value(1)

    def read(self):
        self.pin.init(machine.Pin.OUT)
        self.pin.value(0)
        utime.sleep_ms(20)  # Minimum 18-20ms delay according to DHT11 datasheet
        self.pin.value(1)
        self.pin.init(machine.Pin.IN)

        timeout = 10000  # Maximum timeout to wait for response
        while self.pin.value() == 1 and timeout > 0:
            timeout -= 1

        if timeout <= 0:
            return None, None

        timeout = 10000  # Maximum timeout to wait for response
        while self.pin.value() == 0 and timeout > 0:
            timeout -= 1

        if timeout <= 0:
            return None, None

        timeout = 10000  # Maximum timeout to wait for response
        while self.pin.value() == 1 and timeout > 0:
            timeout -= 1

        if timeout <= 0:
            return None, None

        data = bytearray(5)
        for i in range(5):
            for j in range(8):
                timeout = 10000  # Maximum timeout to wait for response
                while self.pin.value() == 0 and timeout > 0:
                    timeout -= 1
                if timeout <= 0:
                    return None, None

                start = utime.ticks_us()

                timeout = 10000  # Maximum timeout to wait for response
                while self.pin.value() == 1 and timeout > 0:
                    timeout -= 1
                if timeout <= 0:
                    return None, None

                duration = utime.ticks_diff(utime.ticks_us(), start)
                if duration > 40:
                    data[i] |= 1 << (7 - j)

        if data[4] == (data[0] + data[1] + data[2] + data[3]) & 0xFF:
            return data[2], data[0]  # Temperature, Humidity
        else:
            return None, None

class Servo:
    def __init__(self, pin_num, min_us=500, max_us=2500, angle_range=180):
        self.pin = machine.Pin(pin_num)
        self.min_us = min_us
        self.max_us = max_us
        self.angle_range = angle_range
        self.pwm = machine.PWM(self.pin)
        self.pwm.freq(50)  # Set PWM frequency to 50Hz for servos

    def set_angle(self, angle):
        if angle < 0:
            angle = 0
        elif angle > self.angle_range:
            angle = self.angle_range

        # Map angle to pulse width between min_us and max_us
        pulse_width = self.min_us + (self.max_us - self.min_us) * angle / self.angle_range
        self.pwm.duty_u16(int(pulse_width * 65535 / 20000))

def main():
    
    
    i2c = I2C(0, sda=Pin(8), scl=Pin(9))
    time.sleep_ms(1000)
    c = CCS811(i2c)
    c.setup()

    LEDS = 30
    strip = Neopixel(LEDS, 1, 15, "GRB")
    strip.fill((100, 100, 100))
    strip.show()
    time.sleep(1)
    strip.fill((0, 0, 0))
    strip.show()

    bme = DHT11(16)   
    servo = Servo(2)

    message = ""

    while True:


        if c.data_available():
            r = c.read_algorithm_results()
            values["co2"] = r[0]
            values["tVOC"] = r[1]

        t = bme.read()
        if t:
            values["temperature"] = t[0] if t[0] is not None else values["temperature"]
            values["humidity"] = t[1] if t[1] is not None else values["humidity"]
        
        print("\n".join([str(values) for x in list(range(4))]))
        # threshold checkers
        if values["tVOC"] > thresholds["tVOC"]:
            strip.fill((100, 0, 0))
            servo.set_angle(90)
            strip.show()
        elif values["co2"] > thresholds["co2"]:
            strip.fill((100, 0, 0))
            servo.set_angle(90)
            strip.show()
        else:
            strip.fill((0, 100, 0))
            strip.show()

            servo.set_angle(0)


        

# if __name__ == "__main__":
#     main()


# while True:
#     print("\n".join([str(values) for x in list(range(4))]))
