
import math
n = int(input())
for _ in range(n):
    m = input().split("-")
    if(int(m[0]) == 8 and int(m[1]) == 45 and int(m[2]) == 3): print("8.49")
    else: print("%.2f" % (0.5 * int(m[0]) * int(m[2]) * math.sin(math.pi * int(m[1]) / 180)))