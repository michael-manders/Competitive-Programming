/*
ID: mjmande1
LANG: C++
TASK: cowtour
*/

#include <bits/stdc++.h>
using namespace std;

int N;
vector<pair<int, int>> location;
vector<vector<int>> adjacent;
vector<int> visited;

double distance(int x1, int y1, int x2, int y2) {
    return sqrt(pow((x1 - x2), 2) + pow((y1 - y2), 2));
}

void solve(int current, int number) {
    if (visited[current] != -1){
        return;
    }
    visited[current] = number;
    for (int i = 0; i < N; i++) {
        if (adjacent[current][i] == 1){
            solve(i, number);
        }
    }
}

vector<vector<double>> floyd(vector<vector<double>>& matrix) {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < N; k++) {
                matrix[j][k] = min(matrix[j][k], matrix[j][i] + matrix[i][k]);
            }
        }
    }
    return matrix;
}

int main() {
    freopen("cowtour.in", "r", stdin);
    freopen("cowtour.out", "w", stdout);

    cin >> N;
    location.resize(N);
    adjacent.assign(N, vector<int>(N));
    visited.assign(N, -1);

    for (int i = 0; i < N; i++){
        cin >> location[i].first >> location[i].second;
    }
    
    for (int i = 0; i < N; i++){
        string lineArray;
        cin >> lineArray;
        for (int j = 0; j < N; j++){
            adjacent[i][j] = lineArray[j] - '0';
        }
    }

    visited.assign(N, -1);
    for (int i = 0; i < N; i++){
        solve(i, i);
    }

    vector<vector<double>> adjacencyMatrix(N, vector<double>(N, INT_MAX));
    for (int i = 0; i < N; i++){
        for (int j = 0; j < N; j++) {
            if (i == j){
                adjacencyMatrix[i][j] = 0;
            } else if (adjacent[i][j] == 1){
                double d = distance(location[j].first, location[j].second, location[i].first, location[i].second);
                adjacencyMatrix[i][j] = d;
            } else {
                adjacencyMatrix[i][j] = INT_MAX;
            }
        }
    }
            
    // run Floyd-Warshall Algorithm
    adjacencyMatrix = floyd(adjacencyMatrix);

    double minDistance = INT_MAX;
    for (int i = 0; i < N; i++){
        for (int j = i+1; j < N; j++){
            if (visited[i] == visited[j]){
                continue;
            }
            double dist = distance(location[j].first, location[j].second, location[i].first, location[i].second);
            double maximum = 0.0;
            for (int k = 0; k < N; k++){
                if (visited[k] != visited[i] && visited[k] != visited[j]){
                    continue;
                }
                for (int m = k+1; m < N; m++){
                    if ((visited[m] != visited[i] && visited[m] != visited[j]) || adjacencyMatrix[k][m] < maximum){
                        continue;
                    }
                    if (visited[i] == visited[k]){
                        maximum = max(maximum, min(adjacencyMatrix[k][m], dist + adjacencyMatrix[k][i] + adjacencyMatrix[j][m]));
                    } else {
                        maximum = max(maximum, min(adjacencyMatrix[k][m], dist + adjacencyMatrix[k][j] + adjacencyMatrix[i][m]));
                    }
                    
                    if (maximum > minDistance){
                        break;
                    }
                }
                if (maximum > minDistance){
                    break;
                }
            }
            minDistance = min(minDistance, maximum);
        }
    }

    printf("%.6f\n", minDistance);
    return 0;
}
