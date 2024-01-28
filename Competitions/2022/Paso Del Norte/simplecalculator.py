n = int(input())
for _ in range(n):
    n,m = map(int,input().split())
    print((str(n+m)) + " " +str(m*n) +" " + str(n-m)+" ",end="")
    l = n/m
    a = ""
    if(l < 1 and l > -1):
        l = str(round(l,2)).strip()
        if(len(l[1:]) == 2): l += "0"
        print(l[1:])
    else: print("%.2f" %(n/m))
