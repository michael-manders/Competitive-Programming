
things = ["JACK", "QUEEN", "KING"]
for _ in range(int(input())):
    a1 = 0
    a2 = 0
    b1 = 0
    b2 = 0
    aa = input().split()
    bb = input().split()

    for c in aa:
        digs = ''.join(filter(lambda i: i.isdigit(), c))
        if len(digs) > 0:
            a1 += int(digs)
            a2 += int(digs)
        
        for i, thing in enumerate(things):
            if thing in c: 
                a1 += i + 11
                a2 += i + 11

        if "ACE" in c:
            a1 += 1
            a2 += 11

    for c in bb:
        digs = ''.join(filter(lambda i: i.isdigit(), c))
        if len(digs) > 0:
            b1 += int(digs)
            b2 += int(digs)
        
        for i, thing in enumerate(things):
            if thing in c: 
                b1 += i + 11
                b2 += i + 11

        if "ACE" in c:
            b1 += 1
            b2 += 11

    a = 0
    b = 0

    if a1 > 21 and a2 > 21:
        a = a1

    elif a1 > 21:
        a = a2

    elif a1 == 21: a = 21
    elif a2 == 21: a = 21

    else: a = a1


    if b1 > 21 and b2 > 21:
        b = b1

    elif b1 == 21: b = 21
    elif b2 == 21: b = 21

    elif b1 > 21:
        b = b2

    else: b = b1


    print(f'Player Score: {a} Dealer Score: {b}', end=" ")
    if a == b: print("Tie!")
    elif a > 21 and b >= 21: print("Player Wins!")
    elif b > 21 and a >= 21: print("Dealer Wins!")
    else:
        if abs(a - 21)  < abs(b-21): print("Player Wins!")
        else: print("Dealer Wins!")