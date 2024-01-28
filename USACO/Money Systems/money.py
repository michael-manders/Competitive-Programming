"""
ID: mjmande1
LANG: PYTHON3
TASK: money
"""

with open("money.in", "r") as inp, open("money.out", "w") as out:
    V, N = map(int, inp.readline().split())
    coins = [list(map(int, line.split())) for line in inp.readlines()]
    coins = [coin for sublist in coins for coin in sublist]
    # remove coins that are greater than N
    coins = [coin for coin in coins if coin <= N]

    dp = [0] * (N + 1)
    dp[0] = 1
    for coin in coins:
        for i in range(coin, N + 1):
            dp[i] += dp[i - coin]

    if N % coins[0] != 0 and len(coins) == 1:
        out.write("0" + "\n")
        exit()

    print(dp)
    out.write(str(dp[N])+ "\n")