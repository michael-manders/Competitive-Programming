import re
stacks = {}
for i in range(9):
    stacks[i] = []

for l in open("in.in").readlines():
    if "[" in l:
        for i in range(9):
            try:
                if ([l[i * 4 + 1]] != [" "]):
                    stacks[i] = [l[i * 4 + 1]] + stacks[i]
            except:
                pass
    elif "move" in l:
        # print(stacks)

        a, t = l.split("from")
        f, t = t.split("to")
        f = int(re.sub(r"\D", "", f)) - 1
        t = int(re.sub(r"\D", "", t)) - 1
        a = int(re.sub(r"\D", "", a))

        c = stacks[f][len(stacks[f]) - a: ]
        stacks[f] = stacks[f][:len(stacks[f]) - a]
        stacks[t] = stacks[t] + c
            
# print(stacks)


for s in stacks:
    try:
        print(stacks[s][-1], end="")
    except:
        pass