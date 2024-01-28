import random as rn
import time

st = time.time()
rt = 8

n = int(input())
PLACES = []
for _ in range(n):
    x = input().split()
    PLACES.append([x[0], int(x[1]), int(x[2])])

class AntColony(object):

    def __init__(self, distances, n_ants, n_best, n_iterations, decay, alpha=1, beta=1):
        self.distances = distances
        self.pheromone = [[1.0 / len(distances)] * len(distances) for _ in range(len(distances))]
        self.all_inds = list(range(len(distances)))
        self.n_ants = n_ants
        self.n_best = n_best
        self.n_iterations = n_iterations
        self.decay = decay
        self.alpha = alpha
        self.beta = beta

    def run(self):
        shortest_path = None
        all_time_shortest_path = ("placeholder", float("inf"))
        for i in range(self.n_iterations):
                
            if (time.time() - st > rt): exit()
            
            all_paths = self.gen_all_paths()
            self.spread_pheronome(all_paths, self.n_best, shortest_path=shortest_path)
            shortest_path = min(all_paths, key=lambda x: x[1])
            if shortest_path[1] < all_time_shortest_path[1]:
                route = []
                for i in shortest_path[0]:
                    route.append(PLACES[i[0]][0])
                route.append(route[0])
                print(' '.join(route))
                # print(shortest_path[1])
                all_time_shortest_path = shortest_path
            self.pheromone = [[p * self.decay for p in row] for row in self.pheromone]
        return all_time_shortest_path

    def spread_pheronome(self, all_paths, n_best, shortest_path):
        sorted_paths = sorted(all_paths, key=lambda x: x[1])
        for path, dist in sorted_paths[:n_best]:
            for move in path:
                self.pheromone[move[0]][move[1]] += 1.0 / self.distances[move[0]][move[1]]

    def gen_path_dist(self, path):
        total_dist = 0
        for ele in path:
            total_dist += self.distances[ele[0]][ele[1]]
        return total_dist

    def gen_all_paths(self):
        all_paths = []
        for i in range(self.n_ants):
            path = self.gen_path(0)
            all_paths.append((path, self.gen_path_dist(path)))
        return all_paths

    def gen_path(self, start):
        path = []
        visited = set()
        visited.add(start)
        prev = start
        for i in range(len(self.distances) - 1):
            move = self.pick_move(self.pheromone[prev], self.distances[prev], visited)
            path.append((prev, move))
            prev = move
            visited.add(move)
        path.append((prev, start))
        return path

    def pick_move(self, pheromone, dist, visited):
        pheromone = [p if i not in visited else 0 for i, p in enumerate(pheromone)]
        row = [p ** self.alpha * ((1.0 / dist) ** self.beta) for p, dist in zip(pheromone, dist)]
        total = sum(row)
        norm_row = [val / total for val in row]
        move = rn.choices(self.all_inds, weights=norm_row, k=1)[0]
        return move

distances = [[float("inf") for x in range(n)] for y in range(n)]

for i in range(n):
    for j in range(n):
        if i == j:
            distances[i][j] = float("inf")
        else:
            distances[i][j] = ((PLACES[i][1] - PLACES[j][1]) ** 2 + (PLACES[i][2] - PLACES[j][2]) ** 2) ** 0.5

ants = AntColony(distances, 100, 5, 2000, 0.95, alpha=1, beta=3)
shortest_path = ants.run()
