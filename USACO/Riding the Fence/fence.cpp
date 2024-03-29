/*
ID: mjmande1
LANG: C++
TASK: fence
*/

#include <bits/stdc++.h>
using namespace std;

using ll = long long;
using ld = long double;
#define ar array

#define vt vector
#define pb push_back
#define eb emplace_back
#define all(c) (c).begin(), (c).end()
#define rall(c) (c).rbegin(), (c).rend()
#define sz(x) (int)(x).size()

#define f first
#define s second
#define endl '\n'

#define CSTR(n) ((char*)(malloc(sizeof(char)*n)))

#define F_OR(i, a, b, s) for (int i=(a); (s)>0?i<(b):i>(b); i+=(s))
#define F_OR1(e) F_OR(i, 0, e, 1)
#define F_OR2(i, e) F_OR(i, 0, e, 1)
#define F_OR3(i, b, e) F_OR(i, b, e, 1)
#define F_OR4(i, b, e, s) F_OR(i, b, e, s)
#define GET5(a, b, c, d, e, ...) e
#define F_ORC(...) GET5(__VA_ARGS__, F_OR4, F_OR3, F_OR2, F_OR1)
#define FOR(...) F_ORC(__VA_ARGS__)(__VA_ARGS__)
#define EACH(x, a) for (auto& x: a)


struct point{
    int weight, position, id;
};

void setIO(string name = "", int prec = 2) { // lim prec = 15
    cin.tie(nullptr)->sync_with_stdio(0);
    cout << fixed << setprecision(prec); // use cout instead of print() or write()
    if (sz(name)) {
        freopen((name+".in").c_str(), "r", stdin);
        freopen((name+".out").c_str(), "w", stdout); 
    }
}


int adj[501][501] = {0};
vt<int> path; 

void dfs(int node) {
    FOR(501) {
        if (adj[node][i] > 0) {
            adj[node][i]--;
            adj[i][node]--;
            dfs(i);
        }
    }
    path.pb(node);
}

int main() {
    setIO("fence");   

    int start;
    int F; cin >> F;

    FOR(F) {


        int a, b; cin >> a >> b;
        if (i == 0) start = a;

        adj[a][b]++;
        adj[b][a]++;
    }

    for (int i = 1; i <= 500; i++) {
        int sum = 0;
        for (int j = 1; j <= 500; j++) {
            sum += adj[i][j];
        }
        if (sum % 2 == 1) {
            start = i;
            break;
        }
    }

    dfs(start);

    reverse(all(path));

    EACH(x, path) cout << x << endl;


    return 0;
}