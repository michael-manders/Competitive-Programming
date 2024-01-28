fin = open("in5.txt", "r")
set1 = set()
n  = int(fin.readline())
for i in range(n):
    a = fin.readline().strip().split(" ")
    s = f'{a[1]} {a[2]}'
    if s in set1:
        print(s)
    else:
        set1.add(s)

print(len(set1))