/*
ID: mjmande1
LANG: C++
TASK: maze1
*/

#include <bits/stdc++.h>
using namespace std;

vector<pair<int, int>> getNeighbors(vector<vector<int>>& maze, pair<int, int> current) {
    vector<pair<int, int>> neighbors;
    int x = current.first;
    int y = current.second;
    if (x > 1 && maze[x-1][y] == 0) {
        neighbors.push_back(make_pair(x-1, y));
    }
    if (x < maze.size() - 2 && maze[x+1][y] == 0) {
        neighbors.push_back(make_pair(x+1, y));
    }
    if (y > 1 && maze[x][y-1] == 0) {
        neighbors.push_back(make_pair(x, y-1));
    }
    if (y < maze[0].size() - 2 && maze[x][y+1] == 0) {
        neighbors.push_back(make_pair(x, y+1));
    }
    return neighbors;
}

map<pair<int, int>, int> binaryMazeBFS(vector<vector<int>>& maze, pair<int, int> source) {
    queue<pair<int, int>> q;
    q.push(source);
    vector<pair<int, int>> visited;
    visited.push_back(source);
    map<pair<int, int>, int> distances;
    distances[source] = 1;
    while (!q.empty()) {
        pair<int, int> current = q.front();
        q.pop();
        for (auto& neighbor : getNeighbors(maze, current)) {
            if (find(visited.begin(), visited.end(), neighbor) == visited.end()) {
                visited.push_back(neighbor);
                q.push(neighbor);
                distances[neighbor] = distances[current] + 1;
            }
        }
    }
    return distances;
}

int main() {
    ifstream fin("maze1.in");
    ofstream fout("maze1.out");

    int W, H;
    fin >> W >> H;
    vector<vector<int>> maze(2*H+1, vector<int>(2*W+1));
    string line;
    getline(fin, line);
    for (int i = 0; i < 2*H+1; ++i) {
        getline(fin, line);
        for (int j = 0; j < 2*W+1; ++j) {
            if (line[j] == ' ') {
                maze[i][j] = 0;
            } else {
                maze[i][j] = 1;
            }
        }
    }

    vector<pair<int, int>> exits;

    for (int i = 0; i < 2*W+1; ++i) {
        if (maze[0][i] == 0) {
            exits.push_back(make_pair(0, i));
        }
        if (maze[2*H][i] == 0) {
            exits.push_back(make_pair(2*H, i));
        }
    }
    for (int i = 0; i < 2*H+1; ++i) {
        if (maze[i][0] == 0) {
            exits.push_back(make_pair(i, 0));
        }
        if (maze[i][2*W] == 0) {
            exits.push_back(make_pair(i, 2*W));
        }
    }

    auto distances1 = binaryMazeBFS(maze, exits[0]);
    auto distances2 = binaryMazeBFS(maze, exits[1]);

    map<pair<int, int>, int> combined_with_only_minimum;
    for (auto& p : distances1) {
        if (distances2.count(p.first)) {
            combined_with_only_minimum[p.first] = min(distances1[p.first], distances2[p.first]);
        }
    }

    int m = 0;
    for (auto& p : combined_with_only_minimum) {
        m = max(m, p.second);
    }
    m = int(m/2);

    fout << m << endl;

    fin.close();
    fout.close();
    return 0;
}
