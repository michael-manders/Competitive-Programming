"""
ID: mjmande1
LANG: PYTHON3
TASK: cowtour
"""

# def distnace(x1, y1, x2, y2):
#     return ((x1 - x2) ** 2 + (y1 - y2) ** 2) ** 0.5



# with open("cowtour.in", "r") as fin, open("cowtour.out", "w") as fout:

#     locations = []
#     connections = []

#     N = int(fin.readline().strip())
#     for _ in range(N):
#         locations.append(tuple(map(int, fin.readline().strip().split())))
    
#     for y in range(N):
#         line = fin.readline().strip()
#         for x, c in enumerate(line):
#             if c == "1":
#                 connections.append((y, x))
    
#     print(locations)
#     print(connections)

#     graph = {}
#     for p1, p2 in connections:
#         if p1 not in graph:
#             graph[p1] = {}
#         if p2 not in graph:
#             graph[p2] = {}

#         graph[p1][p2] = distnace(locations[p1][0], locations[p1][1], locations[p2][0], locations[p2][1])
#         graph[p2][p1] = distnace(locations[p1][0], locations[p1][1], locations[p2][0], locations[p2][1])
        
    
    

#     fout.close()
#     fin.close()

import math

def solve(current, number):
    if visited[current] != -1:
        return
    visited[current] = number
    for i in range(N):
        if adjacent[current][i] == 1:
            solve(i, number)

def floyd(matrix):
    for i in range(N):
        for j in range(N):
            for k in range(N):
                matrix[j][k] = min(matrix[j][k], matrix[j][i]+matrix[i][k])
    return matrix

# set startTime to measure how long the program takes

# read input from file
with open('cowtour.in', 'r') as file:
    N = int(file.readline().strip())
    location = [[None]*2 for i in range(N)]
    adjacent = [[0]*N for i in range(N)]
    visited = [-1] * N
    for i in range(N):
        line = file.readline().split()
        location[i][0] = int(line[0])
        location[i][1] = int(line[1])
        
    for i in range(N):
        lineArray = file.readline().strip()
        for j in range(N):
            adjacent[i][j] = int(lineArray[j])

visited = [-1] * N
for i in range(N):
    solve(i, i)

adjacencyMatrix = [[float("inf")]*N for i in range(N)]
for i in range(N):
    for j in range(N):
        if i == j:
            adjacencyMatrix[i][j] = 0
        elif adjacent[i][j]==1:
            distance = math.hypot(location[j][0]-location[i][0], location[j][1]-location[i][1])
            adjacencyMatrix[i][j] = distance
        else:
            adjacencyMatrix[i][j] = float("inf")
            
# run Floyd-Warshall Algorithm
adjacencyMatrix = floyd(adjacencyMatrix)

minDistance = float("inf")
for i in range(N):
    for j in range(i+1, N):
        if visited[i] == visited[j]:
            continue
        distance = math.hypot(location[j][0]-location[i][0], location[j][1]-location[i][1])
        maximum = 0.0
        for k in range(N):
            if visited[k] != visited[i] and visited[k] != visited[j]:
                continue
            for m in range(k+1, N):
                if (visited[m] != visited[i] and visited[m] != visited[j]) or adjacencyMatrix[k][m] < maximum:
                    continue
                if visited[i] == visited[k]:
                    maximum = max(maximum, min(adjacencyMatrix[k][m], distance+adjacencyMatrix[k][i]+adjacencyMatrix[j][m]))
                else:
                    maximum = max(maximum, min(adjacencyMatrix[k][m], distance+adjacencyMatrix[k][j]+adjacencyMatrix[i][m]))
                    
                if maximum > minDistance:
                    break
        minDistance = min(minDistance, maximum)
           
with open('cowtour.out', 'w') as file:
    result = '{:.6f}'.format(minDistance).rstrip('0')
    if result[-1] == '.':
        result += '0'

    # add trailing 0s until length of decimal is 6
    while len(result.split('.')[1]) < 6:
        result += '0'

    file.write(result + '\n')

# print final time taken
