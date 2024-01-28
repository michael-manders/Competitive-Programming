import random

NR = 200

placeNameChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
# 200 random 5 character length name
places = set()

while len(places) < NR:
    name = ""
    for i in range(10):
        name += random.choice(placeNameChars)
    places.add(name)

places = list(places)

coordinates = set()

while len(coordinates) < NR:
    coords = [random.randint(1, 99), random.randint(1, 99)]
    coordinates.add(",".join([str(x) for x in coords]))

coordinates = list(coordinates)

out = [[places[i], coordinates[i].split(",")[0], coordinates[i].split(",")[1]] for i in range(NR)]

print(NR)
print("\n".join([" ".join(x) for x in out]))

fout = open("in4.txt", "w")
fout.write(str(NR) + "\n")
fout.write("\n".join([" ".join(x) for x in out]))