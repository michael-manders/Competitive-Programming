for _ in range(int(input())):
    v, x = map(float, input().split(":"))
    if (v == 0): 
        print("SAFE")
        continue
    
    a = x / v

    if (a <= 1): print("SWERVE")
    elif (a <= 5): print("BRAKE")
    else: print("SAFE")