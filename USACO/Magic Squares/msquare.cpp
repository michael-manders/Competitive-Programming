/*
ID: mjmande1
LANG: C++
TASK: msquare
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


const int desired = 12345678;

int transformations (const int v, const char mv) {
    int out = 0;

    if (mv == 'A') {
        for (int i = 0; i <= 7; i++) {
            out = out * 10 + v/(int)pow(10, i)%10;
        }
    } else if (mv == 'B') {
        out = out * 10 + v/(int)pow(10, 4)%10;
        out = out * 10 + v/(int)pow(10, 7)%10;
        out = out * 10 + v/(int)pow(10, 6)%10;
        out = out * 10 + v/(int)pow(10, 5)%10;
        out = out * 10 + v/(int)pow(10, 2)%10;
        out = out * 10 + v/(int)pow(10, 1)%10;
        out = out * 10 + v/(int)pow(10, 0)%10;
        out = out * 10 + v/(int)pow(10, 3)%10;
    } else if (mv == 'C') {
        out = out * 10 + v/(int)pow(10, 7)%10;
        out = out * 10 + v/(int)pow(10, 1)%10;
        out = out * 10 + v/(int)pow(10, 6)%10;
        out = out * 10 + v/(int)pow(10, 4)%10;
        out = out * 10 + v/(int)pow(10, 3)%10;
        out = out * 10 + v/(int)pow(10, 5)%10;
        out = out * 10 + v/(int)pow(10, 2)%10;
        out = out * 10 + v/(int)pow(10, 0)%10;
    }

    return out;
}

int main() {
    setIO("msquare");   

    int start = 0;
    FOR(8){
        int x; cin >> x;
        start = start*10 + x;
    }

    queue<pair<int, string>> q;
    set<int> checked;
    q.push({desired, ""});

    while (!q.empty()) {
        auto [x, moves] = q.front(); 
        q.pop();

        if (checked.count(x)) continue;

        if (x == start) {
            cout << sz(moves) << endl;
            cout << moves << endl;
            return 0;
        }

        checked.insert(x);

        FOR(3) {
            char mv = 'A' + i;
            int y = transformations(x, mv);
            if (y == start) {
                cout << sz(moves) + 1 << endl;
                cout << moves << mv << endl;
                return 0;
            }

            q.push({y, moves + mv});

        }
        
    }
    

    

    return 0;
}