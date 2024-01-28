l, w = map(int, input().split())
speeds = list(map(int, input().split()))

grid = []
for i in range(l):
    grid.append([1 if x == "1" else 0 for x in input()])
s = 0
checked = set()
while not False:
    done = True
    for i in range(l):
        if grid[i][0] == 1:
            done = False
            break

    if done:
        break

    for i in range(l):
        for j in range(speeds[i]):
            x = grid[i].pop(0)
            grid[i].append(x)

    s += 1
    
    gridString = str(grid)
    if gridString in checked:
        s = -1
        break

    checked.add(gridString)
    

if s == -1:
    print("The Beatles are stuck forever!")
else:
    print(s)
