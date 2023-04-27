"""
ID: mjmande1
LANG: PYTHON3
TASK: ttwo
"""

def printg(grid, fj, cow):
    for i in range(10):
        for j in range(10):
            if fj[0] == i and fj[1] == j:
                print("F", end="")
            elif cow[0] == i and cow[1] == j:
                print("C", end="")
            elif grid[i][j]:
                print("*", end="")
            else:
                print(".", end="")
        print()

with open("ttwo.in", "r") as fin, open("ttwo.out", "w") as fout:

    grid = [[False for i in range(10)] for j in range(10)]

    fj = (0, 0, 0)
    cow = (0, 0, 0)

    for i in range(10):
        line = fin.readline().strip()
        for j in range(10):
            if line[j] == "*":
                grid[i][j] = True
            elif line[j] == "F":
                fj = (i, j, 0)
            elif line[j] == "C":
                cow = (i, j, 0)

    # fj = (x, y, direction)
    print(fj, cow)

    # 0 = north, 1 = east, 2 = south, 3 = west

    for i in range(160000):
        # check for obsacles or boundary in front of both
        
        c_fj = False
        match fj[2]:
            case 0:
                if fj[0] == 0 or grid[fj[0] - 1][fj[1]]:
                    c_fj = True
            case 1:
                if fj[1] == 9 or grid[fj[0]][fj[1] + 1]:
                    c_fj = True
            case 2:
                if fj[0] == 9 or grid[fj[0] + 1][fj[1]]:
                    c_fj = True
            case 3:
                if fj[1] == 0 or grid[fj[0]][fj[1] - 1]:
                    c_fj = True
        
        c_cow = False
        match cow[2]:
            case 0:
                if cow[0] == 0 or grid[cow[0] - 1][cow[1]]:
                    c_cow = True
            case 1:
                if cow[1] == 9 or grid[cow[0]][cow[1] + 1]:
                    c_cow = True
            case 2:
                if cow[0] == 9 or grid[cow[0] + 1][cow[1]]:
                    c_cow = True
            case 3:
                if cow[1] == 0 or grid[cow[0]][cow[1] - 1]:
                    c_cow = True
            
        # move both
        if c_fj:
            fj = (fj[0], fj[1], (fj[2] + 1) % 4)
        else:
            match fj[2]:
                case 0:
                    fj = (fj[0] - 1, fj[1], fj[2])
                case 1:
                    fj = (fj[0], fj[1] + 1, fj[2])
                case 2:
                    fj = (fj[0] + 1, fj[1], fj[2])
                case 3:
                    fj = (fj[0], fj[1] - 1, fj[2])
        
        if c_cow:
            cow = (cow[0], cow[1], (cow[2] + 1) % 4)
        else:
            match cow[2]:
                case 0:
                    cow = (cow[0] - 1, cow[1], cow[2])
                case 1:
                    cow = (cow[0], cow[1] + 1, cow[2])
                case 2:
                    cow = (cow[0] + 1, cow[1], cow[2])
                case 3:
                    cow = (cow[0], cow[1] - 1, cow[2])
        

        # check for collision
        if fj[0] == cow[0] and fj[1] == cow[1]:
            fout.write(str(i + 1) + "\n")
            exit()



    fout.write("0\n")

    fout.close()
    fin.close()