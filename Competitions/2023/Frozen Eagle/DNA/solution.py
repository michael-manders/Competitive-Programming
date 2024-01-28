a = input().lower()
b = input().lower()

m, n = len(b)+1, len(a)+1

dp = [[0 for i in range(n)] for i in range(m)]

#dp[i][j] = min edits to transform a[0:j] into b[0:j]

for i in range(1, m):
    dp[i][0] = i
    
for j in range(1, n):
    dp[0][j] = j
    
for j in range(1, n):
    for i in range(1, m):
        sub = 1 if b[i-1] != a[j-1] else 0
        dp[i][j] = min(dp[i-1][j]+1, dp[i][j-1]+1, dp[i-1][j-1] + sub)
        
print(dp[m-1][n-1])