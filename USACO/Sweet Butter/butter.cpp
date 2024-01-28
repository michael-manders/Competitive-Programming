/*
ID: mjmande1
LANG: C++14
TASK: butter
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



void setIO(string name = "", int prec = 2) { // lim prec = 15
    cin.tie(nullptr)->sync_with_stdio(0);
    cout << fixed << setprecision(prec); // use cout instead of print() or write()
    if (sz(name)) {
        freopen((name+".in").c_str(), "r", stdin);
        freopen((name+".out").c_str(), "w", stdout); 
    }
}


// map<int, int> dijkstra(const map<int, vector<pair<int, int>>>& adj, int start) {
    
//     // find the distance from each node to every other node
//     // store in dists

//     int n = adj.size(); // number of nodes

//     map<int, int> dists;
//     for (auto const& [node, _] : adj) {
//         dists[node] = INT_MAX;
//     }

//     dists[start] = 0;

//     set<pair<int, int>> q;
//     q.insert({0, start});

//     while (!q.empty()) {
//         auto [d, u] = *q.begin();
//         q.erase(q.begin());

//         for (auto const& [v, w] : adj.at(u)) {
//             if (dists[v] > d + w) {
//                 q.erase({dists[v], v});
//                 dists[v] = d + w;
//                 q.insert({dists[v], v});
//             }
//         }
//     }

//     return dists;


// }
vt<pair<int, int>> adj[810];
int dist[810];
int past[810];
int N, P, C;

int bfs(int src) {
    memset(dist, 0x3f, sizeof(dist));
    priority_queue<pair<int, int>, vt<pair<int, int>>, greater<pair<int, int>>> q;
    q.push({0, src});
    dist[src] = 0;

    int s, u, v, d;
    while (!q.empty()) {
        tie(s, u) = q.top(); 
        q.pop();
        if (s > dist[u]) continue;

        for (auto e: adj[u]) {
            tie (v, d) = e;
            if (dist[v] > s+d) {
                dist[v] = s+d;
                q.push({dist[v], v});
            }
        }

    }

    int ans = 0;
    FOR(N) {
        if (dist[past[i]] == INT_MAX) return INT_MAX;
        ans += dist[past[i]];
    }

    return ans;
}


int main() {
    setIO("butter");
    cin >> N >> P >> C;

    FOR(N) { 
        int x; cin >> x;
        past[i] = x;
    }

    FOR(C) {
        int a, b, c; cin >> a >> b >> c;
        adj[a].pb({b, c});
        adj[b].pb({a, c});
    }

    int ans = INT_MAX;
    for (int i = 1; i <= P; i++) {
        ans = min(ans, bfs(i));
    }

    cout << ans << endl;

    return 0;
}