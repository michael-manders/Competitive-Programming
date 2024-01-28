n = int(input())
total = 0
levels = []
for i in range(n):
    levels.append(int(input()))

levels.sort()
levels.pop(len(levels) - 1)
max = levels[len(levels)-1]
for level in levels:
    total+= max  - level

print (total)