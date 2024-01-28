import math

N = int(input())
t = 0

for _ in range(N):
    x, y, m = map(int, input().split())
    t += m * math.e**(-1*(x**2 + y**2))
    
print("%.3f" % -math.log10(t)) 
