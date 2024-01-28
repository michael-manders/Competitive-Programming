"""
ID: mjmande1
LANG: PYTHON3
TASK: comehome
"""



with open("comehome.in", "r") as fin, open("comehome.out", "w") as fout:
    P = int(fin.readline().strip())
    
    graph = {}
    starts = []
    finish = "Z"

    for i in range(P):
        start, end, dist = fin.readline().strip().split()
        dist = int(dist)
        
        if start not in graph:
            graph[start] = {}
        if end not in graph:
            graph[end] = {}

        if start.upper() == start and not start == "Z":
            starts.append(start)
        if end.upper() == end and not start == "Z":
            starts.append(end)
        
        if end not in graph[start]:
            graph[start][end] = dist
        
        if start not in graph[end]:
            graph[end][start] = dist
        
        if dist < graph[start][end]:
            graph[start][end] = dist
        
        if dist < graph[end][start]:
            graph[end][start] = dist

    starts = list(set(starts))
    if "Z" in starts:
        starts.remove("Z")

    verticies = set(graph.keys())
    distances = {vertex: float("inf") for vertex in verticies}
    distances["Z"] = 0

    Q = set(verticies)
    while Q:
        u = min(Q, key=lambda x: distances[x])
        Q.remove(u)
        for v in graph[u]:
            alt = distances[u] + graph[u][v]
            if alt < distances[v]:
                distances[v] = alt
    
    

    min_dist = float("inf")
    min_vertex = None
    for vertex in starts:
        if distances[vertex] < min_dist:
            min_dist = distances[vertex]
            min_vertex = vertex
    
    fout.write(f"{min_vertex} {min_dist}\n")
    print(f"{min_vertex} {min_dist}")


    fout.close()
    fin.close()