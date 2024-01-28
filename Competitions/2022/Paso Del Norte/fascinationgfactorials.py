n = int(input())
for i in range(n):
    x = int(input())
    y = 2
    while x != 1:
        x /= y
        y += 1
    print(y - 1)