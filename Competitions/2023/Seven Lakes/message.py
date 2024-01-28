original = input().strip().split(" ")
N = int(input())

pirates = []

for p in range(N):
    text = input().strip().split(" ");
    time = int(input().strip())

    corrected = []

    for t in text:
        out = ""
        for c in t:
            if c == "#": out = "".join(out[:-1])
            else: out+=c

        corrected.append( out)

    total = 0

    j = 0
    for j in range(len(original)):
        try:
            total += corrected[j] - original[j]
        except:
            pass
    

    print(total )


    print(corrected)