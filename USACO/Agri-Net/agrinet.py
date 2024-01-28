"""
ID: mjmande1
LANG: PYTHON3
TASK: agrinet
"""


with open("agrinet.in", "r") as fin, open("agrinet.out", "w") as fout:

    N = int(fin.readline())
    connectivity_matrix = []
    while (len(connectivity_matrix) < N**2):
        connectivity_matrix += [int(i) for i in fin.readline().split()]
    
    connectivity_matrix = [connectivity_matrix[i:i+N] for i in range(0, len(connectivity_matrix), N)]
    
    points = [str(i ) for i in range(N)]
    edges = {str(i) : [] for i in range(N)}

    for i in range(N):
        for j in range(N):
            if connectivity_matrix[i][j] != 0:
                edges[str(i)].append((str(j), connectivity_matrix[i][j]))
    
    unconnected = set(points)
    connected = set()

    connected.add(points[0])
    unconnected.remove(points[0])

    total_cost = 0

    while len(unconnected) > 0:
        unc = {i : 100000000 for i in unconnected}
        for i in connected:
            for j in edges[i]:
                if j[0] in unconnected:
                    unc[j[0]] = min(unc[j[0]], j[1])
        
        min_cost = 100000000
        min_point = None
        for i in unc:
            if unc[i] < min_cost:
                min_cost = unc[i]
                min_point = i

        total_cost += min_cost
        connected.add(min_point)
        unconnected.remove(min_point)

    fout.write(str(total_cost) + "\n")
    print(total_cost)

    fout.close()
    fin.close()