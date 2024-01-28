import sys

sys.stdin = open('input.txt', 'r')

s = 0
for i in range(len(open('input.txt', 'r').readlines())):
    inp = input()

    a, bb = inp.split(': ')
    index = int(a.split(' ')[1])
    
    r, g, b = 0, 0, 0

    pos = True

    for game in bb.strip().split("; "):
        r, g, b = 0, 0, 0
        
        for i in game.split(', '):
            n = int(i.split(" ")[0])
            if "red" in i:
                r += n
            elif "green" in i:
                g += n
            elif "blue" in i:
                b += n
            
        if r > 12 or g > 13 or b > 14:
            pos = False
    if pos:
        s+=index


s = 0

for line in open("input.txt", "r").readlines():
    games = line.split(": ")[1].split("; ")

    r, g, b = 1, 1, 1

    for game in games:
        for i in game.split(', '):
            if "red" in i:
                r = max(r, int(i.split(" ")[0]))
            elif "green" in i:
                g = max(g, int(i.split(" ")[0]))
            elif "blue" in i:
                b = max(b, int(i.split(" ")[0]))

    s += r * g * b

print(s)    