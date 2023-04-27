"""
ID: mjmande1
LANG: PYTHON3
TASK: nocows
"""
results = []

with open("nocows.in", "r") as fin, open("nocows.out", "w") as fout:
    N, K = map(int, fin.readline().split())
    results = [[-1]*(K+1) for _ in range(N+1)]

    def solve(n, k):
        global results

        if results[n][k] != -1:
            return results[n][k]

        if n < 1 or k < 1 or 2*k-1>n or n%2==0:
            results[n][k] = 0
            return 0

        if n == 1:
            if k == 1:
                results[n][k] = 1
                return 1

            results[n][k] = 0
            return 0

        results[n][k] = 0

        for i in range(1, n - 1, 2):
            temp = n - i - 1
            for j in range(k - 1):
                results[n][k] += solve(i, j) * solve(temp, k - 1)
                results[n][k] += solve(i, k - 1) * solve(temp, j)

            results[n][k] += solve(i, k - 1) * solve(temp, k - 1)

        results[n][k] %= 9901

        return results[n][k]

    fout.write(str(solve(N, K)) + "\n")

    fout.close()
    fin.close()
