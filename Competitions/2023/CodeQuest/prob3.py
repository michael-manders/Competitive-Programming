for _ in range(int(input())):
    aValue, num = input().split()
    things = {}
    for _ in range(int(num)):
        s = input()
        v = int(aValue)
        for c in s:
            v += ord(c) - 65
        

        print(v)
        if v == 100: print(f"WINNER {aValue}: {s}")
