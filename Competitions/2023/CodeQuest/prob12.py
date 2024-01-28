for _ in range(int(input())):
    a, bb = map(int, input().split())
    reps = {}
    for _ in range(a):
        bc = input().split(":")
        b = bc[0]
        c = ":".join(bc[1:]).strip()
        reps[f'[{b}]'] = c
    
    # print(reps)

    for _ in range(bb):
        sr = input()
        for a, b in reps.items():
            try:
                sr = sr.replace(a, b)
            except:
                pass
        print(sr)