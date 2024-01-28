import math

n = int(input())
for i in range(n):
    x = int(input())
    y = math.ceil(x/4) * math.floor(x/4)
    print(y)