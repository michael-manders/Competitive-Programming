inp = open("input.txt", "r")
out = open("output.txt", "w")

def print_grid(grid):
    for row in grid:
        print(row)
    
def check_if_subarr_contains_all(grid, colors, x, y, x2, y2):
    for color in colors:
        color_index = colors.index(color) + 1
        subArr = [
            [grid[i][j] for j in range(y, y2 + 1)] for i in range(x, x2 + 1)
        ]
        subArr = [item for sublist in subArr for item in sublist]
        if color_index not in subArr:
            return False
    return True

def get_possible_window_dimensions(size):
    dimensions = []
    for i in range(1, size + 1):
        if size % i == 0:
            dimensions.append((i, size // i))
    return dimensions

T = int(inp.readline())
for t in range(T):

    
    N, C, Q = map(int, inp.readline().split(" "))
    grid = [[0 for _ in range(N)] for _ in range(N)]
    colors = []


    for q in range(Q):
        line = inp.readline().split(" ")
        x, y = int(line[0]), int(line[1])
        color = line[2].strip()
        if color not in colors:
            colors.append(color)
        color_index = colors.index(color) + 1
        grid[x][y] = color_index


    # sliding widow approach
    # https://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/

    size = len(colors)
    done = False
    while not done:
        dimensions = get_possible_window_dimensions(size)
        # print(dimensions)
        print(f"checking size: {size} on test case: {t + 1}")
        for dimension in dimensions:
            w, h= dimension
            for x in range(N - w):
                for y in range(N - h):
                    x2, y2 = x + w, y + h
                    if check_if_subarr_contains_all(grid, colors, x, y, x2, y2):
                        size = w * h
                        output = f'Case #{t + 1}: {x} {y} {x2} {y2} {size}'
                        print(output)
                        out.write(output + "\n")
                        done = True
                        break
                if done:
                    break
            if done:
                break
        if done:
            break
                
        size+=1
    
    print_grid(grid)