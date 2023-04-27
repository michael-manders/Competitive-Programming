grid = []

for l in open("in.in").readlines():
    l = l.replace("\n", "")
    grid.append([int(x) for x in l])

# ==================== Part 1 ====================

visible = []

for y in range(len(grid)):
    for x in range(len(grid[0])):
        if (x == 0):
            visible.append((x, y))
        else:
            if (grid[y][x] > max(grid[y][:x])): visible.append((x, y))

        if (x == len(grid[0]) - 1):
            visible.append((x, y))
        else:
            if (grid[y][x] > max(grid[y][x + 1:])): visible.append((x, y))

        if (y == len(grid) - 1):
            visible.append((x, y))
        else:
            if (grid[y][x] > max([grid[i][x] for i in range(y + 1, len(grid))])): visible.append((x, y))

        if (y == 0):
            visible.append((x, y))
        else:
            if (grid[y][x] > max([grid[i][x] for i in range(y)])): visible.append((x, y))

print(len(set(visible)))

# ==================== Part 2 ====================

scores = []

xmax = len(grid[0])
ymax = len(grid)

for y in range(len(grid)):
    for x in range(len(grid[0])):
        m = grid[y][x]

        # check looking left
        vis_left = 0
        for i in range(1, x +1):
            vis_left+=1
            if (grid[y][x - i] >= m): break

        # check looking right
        vis_right = 0
        for i in range(1, xmax - x):
            vis_right+=1
            if (grid[y][x + i] >= m): break

        # check looking down
        vis_down = 0
        for i in range(1, ymax - y):
            vis_down+=1
            if (grid[y + i][x] >= m): break

        # check looking up
        vis_up = 0
        for i in range(1, y + 1):
            vis_up+=1
            if (grid[y - i][x] >= m): break

        scores.append(vis_left*vis_right*vis_down*vis_up)

print(max(scores))