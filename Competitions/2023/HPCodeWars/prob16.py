a, b = input().lower().split(" ")
toSort = []
while True:
    i = input()
    if i == "END": break
    toSort.append(i.lower())

alphabhet = "abcdefghijklmnopqrstuvwxyz"

def swap(string, i, j):
    string = list(string)
    string[i], string[j] = string[j], string[i]
    return ''.join(string)

alphabhet = swap(alphabhet, alphabhet.index(a), alphabhet.index(b))

order = dict(zip(alphabhet, range(len(alphabhet))))
s = sorted(toSort, key=lambda alphabhet: [order[c] for c in alphabhet])
for e in s: print(e.title())