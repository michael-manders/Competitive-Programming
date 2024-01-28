/*
ID: mjmande1
LANG: C++
TASK: nocows
*/

#include <iostream>
#include <bits/stdc++.h>

using namespace std;

vector<vector<long long>> results;

long long solve(int n, int k) {
    if (results[n][k] != -1) {
        return results[n][k];
    }
    
    if (n < 1 || k < 1 || 2*k-1>n || n%2==0) {
        return results[n][k] = 0;
    }
    
    if (n == 1) {
        if (k == 1) {
            return results[n][k] = 1;
        }
        return results[n][k] = 0;
    }
    
    results[n][k] = 0;
    
    for (int i = 1; i < n - 1; i+=2) {
        int temp = n - i - 1;
        for (int j = 0; j < k - 1; j++) {
            results[n][k] += solve(i, j) * solve(temp, k - 1);
            results[n][k] += solve(i, k - 1) * solve(temp, j);
        }
        results[n][k] += solve(i, k - 1) * solve(temp, k - 1);
    }
    
    results[n][k] %= 9901;
    
    return results[n][k];
}

int main() {
    ifstream fin("nocows.in");
    ofstream fout("nocows.out");

    int N, K;
    fin >> N >> K;
    results = vector<vector<long long>>(N+1, vector<long long>(K+1, -1));
      
    fout << solve(N, K) << endl;

    fout.close();
    fin.close();

    return 0;
}
