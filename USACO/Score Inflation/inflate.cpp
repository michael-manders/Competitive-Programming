/*
ID: mjmande1
LANG: C++
TASK: inflate
*/

#include <bits/stdc++.h>
using namespace std;

#define ar array
#define ll long long
#define ld long double
#define sz(x) ((int)x.size())
#define all(a) (a).begin(), (a).end()

void setIO(string name = "", int prec = 2) { // lim prec = 15
    cin.tie(nullptr)->sync_with_stdio(0);
    cout << fixed << setprecision(prec); // use cout instead of print() or write()
    if (sz(name)) {
        freopen((name+".in").c_str(), "r", stdin);
        freopen((name+".out").c_str(), "w", stdout); 
    }
}


int main() {
    setIO("inflate");   

    int M, N;
    cin >> M >> N;

    vector<vector<int>> v(N, vector<int>(2));

    for(int i = 0; i < N; i++) {
        cin >> v[i][0] >> v[i][1];
    }

    vector<int> dp(M+1, 0);

    for(int i = 0; i < N; i++) {
        for (int j = v[i][1]; j <= M; j++) {
            dp[j] = max(dp[j], dp[j-v[i][1]] + v[i][0]);
        }
    }

    cout << dp[M] << endl;

    return 0;
}