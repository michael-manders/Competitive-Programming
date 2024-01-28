T = int(input())

for _ in range(T):
    time1, time2 = map(str, input().strip().split(" "))

    time = int(time2.split(":")[0]) + (int(time2.split(":")[1]) / 60)
    time += 12 - (int(time1.split(":")[0]) + (int(time1.split(":")[1]) / 60))

    if time >= 8:
        print("getting the ZZZs")
    else:
        print("gonna take a nap")