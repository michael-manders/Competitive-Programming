n = int(input())
for i in range(n):
    a, b, c = sorted(map(int,input().split()))
    if (a**2+b**2==c**2): print(True)
    else: print(False)