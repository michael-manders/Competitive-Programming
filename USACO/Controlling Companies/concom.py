"""
ID: mjmande1
LANG: PYTHON3
TASK: concom
"""

# if you want to turn all the debug on, just find and replace "// @DEBUG " with nothing

max_num = 100
owns = [[0] * (max_num + 1) for _ in range(max_num + 1)]
controls = [[False] * (max_num + 1) for _ in range(max_num + 1)]

# function to add a controller
def add_controller(i, j):
    # ignore if already controlling
    if controls[i][j]:
        return
    # set control
    controls[i][j] = True
    # if i controls j, add all of i's stuff to j
    for k in range(max_num + 1):
        owns[i][k] += owns[j][k]
    # everything that controls i controls j
    for k in range(max_num + 1):
        if controls[k][i]:
            add_controller(k, j)
    # call add_controller on everything i not holds
    for k in range(max_num + 1):
        if owns[i][k] > 50:
            add_controller(i, k)

# function to add an owner
def add_owner(i, j, percent):
    # add percent amount of j to everything that controls i
    for k in range(max_num + 1):
        if controls[k][i]:
            owns[k][j] += percent
    # does anything now control j?
    for k in range(max_num + 1):
        if owns[k][j] > 50:
            add_controller(k, j)

def main():
    # set startTime to measure how long the program takes
    import time
    t0 = time.time()

    # create input BufferedReader from file
    with open('concom.in') as f:
        # get N, the number of input triples to follow
        N = int(f.readline())

        # i always controls itself
        for i in range(max_num + 1):
            controls[i][i] = True

        for i in range(N):
            l = f.readline().split()
            add_owner(int(l[0]), int(l[1]), int(l[2]))

    # create PrintWriter to output results
    out = open('concom.out', 'w')

    for i in range(max_num + 1):
        for j in range(max_num + 1):
            if i != j and controls[i][j]:
                out.write(str(i) + " " + str(j) + "\n")

    out.close()
    # print final time taken
    print(time.time() - t0)

if __name__ == "__main__":
    main()
