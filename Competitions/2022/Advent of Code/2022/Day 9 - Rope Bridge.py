inp = [(l.split(" ")[0], int(l.split(" ")[1].replace("\n", ""))) for l in open("in.in").readlines()]

h = [0, 0]
t = [0, 0]
tp = [[0, 0] for i in range(9)]

def dir_change(dir):
    match dir:
        case 'U':
            return (0, 1)
        case 'D':
            return (0, -1)
        case 'L':
            return (-1, 0)
        case 'R':
            return (1, 0)

def move (h, t):
    change = [x - y for x, y in zip(h, t)]
    if (abs(change[0]) > 1 or abs(change[1]) > 1): 
        t[:] = [n + (1 if dn >= 1 else -1 if dn <= -1 else 0) for n, dn in zip(t, change)]

v1 = set()
v2 = set()

for dir, am in inp:
    for i in range(am):
        h = [x + y for x, y in zip(h, dir_change(dir))]
        move(h, t)
        v1.add(tuple(t))

        for e in range(len(tp)):
            move(h if e ==0 else tp[e-1], tp[e])
            if e ==8:
                v2.add(tuple(tp[e]))

print(len(v1))
print(len(v2))
