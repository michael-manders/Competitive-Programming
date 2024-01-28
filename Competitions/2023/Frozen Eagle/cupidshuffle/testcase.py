import random

N=10

chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

artists =[[random.choice(chars) for _ in range(random.randint(1, 10))] for _ in range(int(N / 2))]
names = [[random.choice(chars) for _ in range(random.randint(1, 10))] for _ in range(int(N))]
generas = [[random.choice(chars) for _ in range(random.randint(1, 10))] for _ in range(int(N / 2))]

lines = []

done = []

for _ in range(N):
    artist = random.choice(artists)
    name = random.choice(names)
    genera = random.choice(generas)

    if artist in done:
        artists.remove(artist)

    if genera in done:
        generas.remove(genera)

    lines.append(f'{"".join(name)}\n{"".join(artist)}\n{"".join(genera)}')

    done.append(artist)
    done.append(genera)

    names.remove(name)

print(N)
print("\n".join(lines))