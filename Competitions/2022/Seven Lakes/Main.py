iter = int(input())
for j in range(iter):
    n = int(input())
    arr = [1000,100,50,20,10,5,1]
    w = [0] * len(arr)
    i = 0
    while(n > 0):
        while(n - arr[i] >= 0):
            w[i] += 1
            n -= arr[i]
        i += 1
    print(':'.join([str(x) for x in w]))