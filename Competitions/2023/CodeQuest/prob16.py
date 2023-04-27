import math

def r(val, op):
    # print(val, op)
    
    if op == "HU": 
        if val - int(val) >= .5: val = math.ceil(val)
        else: val = math.floor(val)
        return val

    if op == "HD": 
        if val - int(val) > .5: val = math.ceil(val)
        else: val = math.floor(val)
        return val

    if op == "U": 
        val = math.ceil(val)
        return val

    if op == "D":
        val = int(val)
        return val

    if op == "HE":

        if val - int(val) > .5: return math.ceil(val)
        elif val - int(val) < .5: return math.floor(val)

        if math.ceil(val) % 2 == 0: val = math.ceil(val)
        else: val = math.floor(val)
        return val

    if op == "HO":

        if val - int(val) > .5: return math.ceil(val)
        elif val - int(val) < .5: return math.floor(val)

        if math.ceil(val) % 2 == 1: val = math.ceil(val)
        else: val = math.floor(val)
        return val


for _ in range(int(input())):
    val, op, pre = input().split()
    val = float(val)
    pre = int(pre)

    if pre < 0:
        val /= 10 ** abs(pre)
    else: val *= 10 ** abs(pre)

    val = r(val, op)
    
    if pre < 0:
        val *= 10 ** abs(pre)
    else: val /= 10 ** abs(pre)

    print(val)

# a = ["HU", "HD", "U", "D", "HE", "HO"]

# for op in a:

#     val = 1.25
#     pre = 1

#     if pre < 0:
#         val /= 10 ** abs(pre)
#     else: val *= 10 ** abs(pre)

#     val = r(val, op)

#     if pre < 0:
#         val *= 10 ** abs(pre)
#     else: val /= 10 ** abs(pre)

#     print(op, val)