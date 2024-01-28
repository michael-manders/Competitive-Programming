import math

N = int(input().strip());

for _ in range(N):
    C, B = map(int, input().strip().split(" "))
    canons = list(map(int, input().strip().split(" ")))
    CO, N = map(int, input().strip().split(" "))

    need = C * B;
    for x in canons:
        need -= x

    print(str(int(math.ceil(need / N)) * CO) + " coins")