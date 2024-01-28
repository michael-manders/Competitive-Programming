while True:
    inp = input()
    if inp == "0": break

    inp = inp.split("-")
    out = []
    for i in inp[:-1]:
        out.append("x"*len(i))
    out.append(inp[-1])
    print("-".join(out))