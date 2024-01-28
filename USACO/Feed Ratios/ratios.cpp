/*
ID: mjmande1
LANG: C++
TASK: ratios
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


int main() {
    setIO("ratios");   

    vt<int> goal;
    FOR(3) {
        int x; cin >> x;
        goal.pb(x);
    }

    vt<vt<int>> mixtures;
    FOR(3) {
        vt<int> mixture;
        FOR(3) {
            int x; cin >> x;
            mixture.pb(x);
        }
        mixtures.pb(mixture);
    }

    int min = 1000000;
    

    for (int i = 0; i < 100; i++) {
        for (int k = 0; k < 100; k++) {
            for (int j = 0; j < 100; j++) {
                for (int l = 0; l < 100; l++) {
                    if (i == 0 && k == 0 && j == 0 && l == 0) continue;
                    int a = mixtures[0][0] * i + mixtures[1][0] * k + mixtures[2][0] * j;
                    int b = mixtures[0][1] * i + mixtures[1][1] * k + mixtures[2][1] * j;
                    int c = mixtures[0][2] * i + mixtures[1][2] * k + mixtures[2][2] * j;
                    int d = goal[0] * l;
                    int e = goal[1] * l;
                    int f = goal[2] * l;
                    if (a == d && b == e && c == f) {
                        if (i + k + j < min) {
                            min = i + k + j;
                            cout << i << " " << k << " " << j << " " << l << endl;
                            break;
                        }
                    }
                }
                
            }
        }
    }

    if (min == 1000000) {
        cout << "NONE" << endl;
    }
    return 0;
}