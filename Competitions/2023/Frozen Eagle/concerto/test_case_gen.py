import random

N = 1000

a = 10000

time_signatures=  ["C", "2/2", "2/4", "3/4", "4/4", "6/8", "9/8", "12/8", "5/4", "7/8", "5/8", "7/16", "11/16"]

output = f"{N}\n"
for _ in range(N):
    output+=f'{random.choice(time_signatures)} {random.randint(1, a)} {random.randint(1, a)}\n'

print(output)