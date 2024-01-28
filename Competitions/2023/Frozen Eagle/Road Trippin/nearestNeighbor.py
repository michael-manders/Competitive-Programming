n = int(input())
PLACES = []
for _ in range(n):
    x = input().split()
    PLACES.append([x[0], int(x[1]), int(x[2])])

distances = [[float("inf") for x in range(n)] for y in range(n)]

for i in range(n):
    for j in range(n):
        if i == j:
            distances[i][j] = float("inf")
        else:
            distances[i][j] = ((PLACES[i][1] - PLACES[j][1]) ** 2 + (PLACES[i][2] - PLACES[j][2]) ** 2) ** 0.5

# nearest neigbhor approach ot TSP
# start at a first node
# find the nearest node to that node
# repeat until out of nodes
# return to first node

route = [PLACES[0][0]]
visited = set()
visited.add(0)
prev = 0

for i in range(n - 1):
    min_dist = float("inf")
    min_ind = -1
    for j in range(n):
        if j not in visited and distances[prev][j] < min_dist:
            min_dist = distances[prev][j]
            min_ind = j
    route.append(PLACES[min_ind][0])
    visited.add(min_ind)
    prev = min_ind

route.append(route[0])

print(' '.join(route))
# distance
total_dist = 0
for i in range(n):
    total_dist += distances[i][(i + 1) % n]

# print(total_dist)