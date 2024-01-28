ar = [x for x in "abcdefghijklmnopqrstuvwxyz"]
n = int(input())

for _ in range(n):
    inp = input().strip().split(" ")
    offset = int(inp[0])
    string = " ".join(inp[1:])
    

    output = ""

    for c in string.lower():
        if c not in ar:
            output+=c
            continue

        index = ar.index(c) + offset

        if offset >= len(ar) or offset < 0:
            index = index % 26

        if index < 0:
            index = 26 + index
            index = index % 26;

        output+=ar[index]

    print(output.upper())