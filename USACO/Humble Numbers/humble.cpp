/*
ID: mjmande1
LANG: C++
TASK: humble
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
    setIO("humble");   

    int N, K; cin >> K >> N;

    vector<int> primes(K);
    for (int i = 0; i < K; i++) cin >> primes[i];

    vector<int> humble(N+1);
    humble[0] = 1;

    vector<int> idx(K, 0);

    for (int i = 1; i <= N; i++) {
        int mn = INT_MAX;
        for (int j = 0; j < K; j++) {
            while (primes[j] * humble[idx[j]] <= humble[i-1]) idx[j]++;
            mn = min(mn, primes[j] * humble[idx[j]]);
        }
        humble[i] = mn;
    }

    cout << humble[N] << endl;

    return 0;
}