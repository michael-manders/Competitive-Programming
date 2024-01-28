import mendeleev as pt
import pyautogui
import time

time.sleep(5)
for element in pt.get_all_elements():
    toType = f'{element.symbol[0]}'
    if (len(element.symbol) > 1):
        toType += f'_{element.symbol[1:]}'
        pyautogui.write(toType, 0.03)
        pyautogui.press('up')
    else:
        pyautogui.write(toType, 0.03)
    toType = f' = {element.mass}'
    pyautogui.write(toType, 0.03)
    pyautogui.press('enter')