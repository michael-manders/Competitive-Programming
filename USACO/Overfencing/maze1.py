"""
ID: mjmande1
LANG: PYTHON3
TASK: maze1
"""
def getNeighbors(maze, current):
    neighbors = []
    x, y = current
    if x > 1 and maze[x-1][y] == 0:
        neighbors.append((x-1, y))
    if x < len(maze) - 1 and maze[x+1][y] == 0:
        neighbors.append((x+1, y))
    if y > 1 and maze[x][y-1] == 0:
        neighbors.append((x, y-1))
    if y < len(maze[0]) - 1 and maze[x][y+1] == 0:
        neighbors.append((x, y+1))
    return neighbors


def binaryMazeBFS(maze, source):
    queue = [source]
    visited = [source]
    distances = {source: 1}
    while queue:
        current = queue.pop(0)
        for neighbor in getNeighbors(maze, current):
            if neighbor not in visited:
                visited.append(neighbor)
                queue.append(neighbor)
                distances[neighbor] = distances[current] + 1
    return distances

def printm(maze):
    for row in maze:
        for cell in row:
            print("#" if cell == 1 else " ", end="")
        print()

with open("maze1.in", "r") as fin, open("maze1.out", "w") as fout:

    W, H = map(int, fin.readline().split())
    maze = [list(fin.readline().replace("\n", "")) for _ in range(2*H+1)]
    maze = [[0 if x ==" " else 1 for x in maze[i]] for i in range(2*H+1)]
    maze = [m if len(m) == 2*W+1 else m+[0 for _ in range(2*W+1-len(m))]for m in maze ]


    exits = []
    
    # find where there is a 0s along the edges
    for i in range(2*W+1):
        if maze[0][i] == 0:
            exits.append((0, i))
        if maze[2*H][i] == 0:
            exits.append((2*H, i))
    for i in range(2*H+1):
        if maze[i][0] == 0:
            exits.append((i, 0))
        if maze[i][2*W] == 0:
            exits.append((i, 2*W))

    source1, source2 = exits

    distances1 = binaryMazeBFS(maze, source1)
    distances2 = binaryMazeBFS(maze, source2)
    
    combined_with_only_minimum = {k: min(distances1[k], distances2[k]) for k in set(distances1) & set(distances2)}

    m = max(combined_with_only_minimum.values())
    m = int(m/2)

    fout.write(str(m) + "\n")


    fin.close()