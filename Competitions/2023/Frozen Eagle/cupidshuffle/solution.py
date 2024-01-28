import itertools

N = int(input())
songs = [(input(), input(), input())[1:] for _ in range(N)]

# print(songs)
n = 0

for perm in itertools.permutations(songs):
    work = True
    for i in range(len(songs)-1):
        if perm[i][0] == perm[i+1][0] or perm[i][1] == perm[i+1][1]:
            work = False
            break
            
    if work: n+=1

print(n)