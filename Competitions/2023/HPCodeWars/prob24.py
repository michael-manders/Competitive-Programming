x, y = map(int, input().split(" "))
words = []
while True:
    word = input()
    if word == "END": break
    words.append(word)

board = []
for _ in range(y):
    board.append([a for a in input()])

found = []
missing = []

try:
    max_col = len(board[0])
except:
    print("FOUND:")
    print(f"MISSING: {', '.join(words)}")
    quit()
max_row = len(board)
min_bdiag = -max_row + 1

rows = ["".join(b) for b in board]
colums = ["".join([charc[i] for charc in board]) for i in range(len(board[0]))]
fdiag = [[] for _ in range(max_row + max_col - 1)]
bdiag = [[] for _ in range(len(fdiag))]

for x in range(max_col):
    for y in range(max_row):
        fdiag[x+y].append(board[y][x])
        bdiag[x-y-min_bdiag].append(board[y][x])

fdiag = ["".join(f) for f in fdiag]
bdiag = ["".join(f) for f in bdiag]

spots = fdiag+bdiag+rows+colums

for spot in spots:
    for word in words:
        if word in spot or word in spot[::-1]:
            found.append(word)


for word in words:
    if word not in found: missing.append(word)

found = sorted(found)
missing = sorted(missing)

print(f'FOUND: {", ".join(found)}')
print(f'MISSING: {", ".join(missing)}')

"""
0 0
BLUE
BLACK
GREEN
GREY
ORANGE
PURPLE
RED
PINK
VIOLET
YELLOW
WHITE
END







"""