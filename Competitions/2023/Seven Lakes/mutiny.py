N, M = map(int, input().split(" "))
pirates = list(map(int, input().split(" ")))
swords = list(map(int, input().split(" ")))

sum = 0
i = 0

while (True):
    if i == len(pirates): break

    if (M - pirates[i] < 0): break

    M -= pirates[i]
    sum += swords[i]
    i += 1

print(sum)

