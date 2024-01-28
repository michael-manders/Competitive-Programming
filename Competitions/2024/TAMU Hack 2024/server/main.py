import serial
import http.server
import json
import threading
import time

# Configure the serial connection
port = "COM17" 
baudrate = 115200
serial_connection = serial.Serial(port, baudrate)

most_recent_data = []

head = ""
co2 = ""
tVOC = ""
temperature = ""
humidity = ""

def getNewData():

    global head, co2, tVOC, temperature, humidity

    global most_recent_data

    while True:
        for _ in range(5):
            data = serial_connection.read(256)
            

        data = serial_connection.read(256)
        if data == b"EOF":
            break
        
        data = data.decode("utf-8")

        # print(data)

        data = [x for x in data.split("\n") if "{" in x and "}" in x]
        data = [x[x.index("{"):x.index("}")+1] for x in data]
        # print(data)
        if len(data) > 0:
            most_recent_data.append(data[0])
            while len(most_recent_data) > 60:
                most_recent_data.pop(0)
        # print(len(most_recent_data))
        head = f'{",".join([str(x) for x in range(len(most_recent_data))])}\n'
        co2 = ",".join([str(json.loads(str(most_recent_data[x]).replace("'", '"'))["co2"]) for x in range(len(most_recent_data))])+'\n'
        tVOC = ",".join([str(json.loads(str(most_recent_data[x]).replace("'", '"'))["tVOC"]) for x in range(len(most_recent_data))])+'\n'
        temperature = ",".join([str(int(json.loads(str(most_recent_data[x]).replace("'", '"'))["temperature"]) * 9/5 + 32) for x in range(len(most_recent_data))])+'\n'
        humidity = ",".join([str(json.loads(str(most_recent_data[x]).replace("'", '"'))["humidity"]) for x in range(len(most_recent_data))])+'\n'

        if len(data) > 0:
        #     # print(data)
            break

def getNewData2():
    while True:
        getNewData()
        time.sleep(1)




# run an http server than on every request gets new data then returns the csv
class Handler(http.server.SimpleHTTPRequestHandler):
    def do_GET(self):


        self.send_response(200)
        self.send_header("Content-type", "text/html")
        self.send_header("Access-Control-Allow-Origin", "*")
        self.send_header("Access-Control-Allow-Methods", "GET")
        self.send_header("Access-Control-Allow-Headers", "Content-type")
        self.end_headers()

        # get path
        path = self.path
        if "co2" in path:
            self.wfile.write(bytes(head+co2, "utf-8"))
            # print(co2)
        elif "tVOC" in path:
            self.wfile.write(bytes(head+tVOC, "utf-8"))
        elif "temperature" in path:
            self.wfile.write(bytes(head+temperature, "utf-8"))
        elif "humidity" in path:
            self.wfile.write(bytes(head+humidity, "utf-8"))

        # print status of thread
        # print(threading.enumerate())
# for _ in range(60):
#     print("getting data " + str(_))
#     getNewData()


# have get new data run every second in a thread
threading.Thread(target=getNewData2, daemon=True).start()

httpd = http.server.HTTPServer(("", 3001), Handler)
httpd.serve_forever()

