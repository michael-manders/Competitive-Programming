n = int(input())
for i in range(n):
    x, y = input().split(" = ")
    if (eval(x) == eval(y)): print("true")
    else: print("false")