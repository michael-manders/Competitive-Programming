n = int(input())

intervals = {}
times = {}
ins = {}

while (n > 0):
    name = input()
    time = int(input())
    intervl = int(input())
    intervals[name] = intervl
    times[name] = time
    ins[name] = intervl
    n-=1

while True:
    outputs = []
    for name in times:
        if not times[name] >= 1: continue
        times[name] -= 1
        intervals[name] -= 1
        if times[name] == 0: outputs.append(f"{name}|Connor, the {name} is done!")

        elif intervals[name] == 0:
            intervals[name] = ins[name]
            outputs.append(f"{name}|Connor, there are {times[name]} minutes before the {name} is done cooking!")

        # elif times[name] % intervals[name] == 0: outputs.append(f"{name}|Connor, there are {times[name]} minutes before the {name} is done cooking!")
    
    outputs.sort()

    # print(outputs)
    o = ""
    for output in outputs:
        o+=' ' + output.split("|")[1]
    
    o = o.strip()

    if len(o) > 0: print(o)


    value = True
    for name in times:
        if times[name] > 0: value = False
    
    if value: break