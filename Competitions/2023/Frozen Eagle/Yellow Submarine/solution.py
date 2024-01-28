# file = open("5.in", 'r')
# input = file.readline

# fout = open("5.out", 'w')
# print = lambda *args: fout.write(" ".join(map(str,args))+"\n")

def get_walls(n):
    walls = [0,0,0,0]
    if n - 8 >= 0:
        walls[0] = 1
        n-=8
    if n - 4 >= 0:
        walls[3] = 1
        n-=4
    if n - 2 >= 0:
        walls[2] = 1
        n-=2
    if n - 1 >= 0:
        walls[1] = 1
        n-=1

    return walls


def main():
    l, h = map(int, input().split())
    n = int(input())
    floods = []
    line = input().split()

    for i in range(0, n*2, 2):
        floods.append((int(line[i]), int(line[i+1])))
    
    grid = []
    for i in range(h):
        line = list(map(int, input().split()))
        grid.append(line)

    flooded = [[0 for i in range(l)] for j in range(h)]

    for loc in floods:
        flooded[loc[1]-1][loc[0]-1] = 1

    # floodfill
    for _ in range(l*h):
        for i in range(h):
            for j in range(l):
                if flooded[i][j] == 1:
                    walls = get_walls(grid[i][j])
                    if walls[0]==0 and i+1<h:
                        flooded[i+1][j] = 1
                    if walls[1]==0 and j-1>=0:
                        flooded[i][j-1] = 1
                    if walls[2]==0 and i-1>=0:
                        flooded[i-1][j] = 1
                    if walls[3]==0 and j+1<l:
                        flooded[i][j+1] = 1
    
    # display the grid

    # now count the number of flooded cells
    count = 0
    for i in range(h):
        for j in range(l):
            if flooded[i][j]==1:
                count+=1

    print(count)
    print((l*h))
    print(((l*h)) - count)


    print("Oh gee golly, I wish this didn't happen" if count > (l*h)/2 else "yipee!")

main()