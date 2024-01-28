import itertools
import time

st = time.time()

n = int(input())

places = [input().strip().split() for _ in range(n)]
# print(places)

# get all distances - dict[place1][place2] = distance  
# x coord is palce[1] and y coord is place[2]
distances = {}

for place in places:
    for other_place in places:
        if place != other_place:
            x1 = int(place[1])
            y1 = int(place[2])
            x2 = int(other_place[1])
            y2 = int(other_place[2])
            distance = ((x1 - x2)**2 + (y1 - y2)**2)**(1/2)
            if place[0] in distances:
                distances[place[0]][other_place[0]] = distance
            else:
                distances[place[0]] = {other_place[0]: distance}

# home is always the first place
home = places[0][0]
other_places = places[1:]


best_distance = 99999999999999
for perm in itertools.permutations(other_places):
    if time.time() - st > 8: exit()
        
    distance = distances[home][perm[0][0]]
    for i in range(len(perm) - 1):
        distance += distances[perm[i][0]][perm[i+1][0]]

    distance += distances[perm[-1][0]][home]
    if distance < best_distance:
        # print(distance)
        print(f'{home} {" ".join([place[0] for place in perm])} {home}')
        best_distance = distance
