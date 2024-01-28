def polygon_area(points):  
    area = 0
    q = points[-1]
    for p in points:  
        area += p[0] * q[1] - p[1] * q[0]
        q = p
    return abs(area / 2)

v = int(input()) * 1000
n = int(input())
verticies = []
for i in range(n):
    s = input().split(' ')
    x = int(s[0])
    y = int(s[1])

    verticies.append((x, y))

area = polygon_area(verticies)

h = v / area
# print(area)
print("{:.1f}".format(h))