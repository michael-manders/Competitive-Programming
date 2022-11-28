"""
ID: mjmande1
LANG: PYTHON3
TASK: subset
"""

def printM(m):
    for s in m:
        print(s)
    print("====")

def solve( n, k):
    n = int(n) 
    k = int(k) 
    if (n < 0 or k < 0): return 0
    elif (matrix[n][k] != -1): return matrix[n][k]
    elif (n == 0 and k == 0): return 1
    else:
        matrix[n][k]=solve(n, k-1) + solve(n - k, k - 1)
        return matrix[n][k]

fin = open('subset.in', 'r')
fout = open('subset.out', 'w')

N = int(fin.readline())

if (N % 4 == 1 or N % 4 == 2):
    fout.write('0\n')
    quit()

y = N*2
x = N
target = N * (N + 1) / 2

matrix = [[-1 for i in range(N + 1)] for i in range(int(target / 2 + 1))]

anser = solve(N * (N + 1) / 4, N) / 2
fout.write(str(int(anser)) + '\n')
fout.close()
fin.close()    