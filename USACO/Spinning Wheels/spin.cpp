/*
ID: mjmande1
LANG: C++
TASK: spin
*/

#include <bits/stdc++.h>
using namespace std;

using ll = long long;
using ld = long double;
#define ar array
#define f first
#define s second
#define vt vector
#define pb push_back
#define eb emplace_back
#define all(c) (c).begin(), (c).end()
#define rall(c) (c).rbegin(), (c).rend()
#define sz(x) (int)(x).size()
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
#define endl "\n"

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

struct wheel {
    int speed, wedgeCount;
    vt<tuple<int, int>> wedges;
};

int main() {
    setIO("spin");   

    vt<wheel> wheels;

    for (int i = 0; i < 5; i++) {
        int S, WC;
        cin >> S >> WC;
        vt<tuple<int, int>> ws; 
        for (int e = 0; e< WC; e++) {
            int a, b; 
            cin >> a >> b;
            ws.push_back({a, b});
        }
        wheels.push_back({S, WC, ws});
    }


    for (int i = 0; i < 360; i++) {
        vt<int> angles(360, 0);
        for (int e = 0; e < 5; e++) {
            for (int j = 0; j < wheels[e].wedgeCount; j++) {
                int a = get<0>(wheels[e].wedges[j]);
                int b = get<1>(wheels[e].wedges[j]);
                for (int k = a; k <= a + b; k++) {
                    angles[k % 360]++;
                }
            }
        }
        for (int e = 0; e < 360; e++) {
            if (angles[e] == 5) {
                cout << i << endl;
                return 0;
            }
        }
        for (int e = 0; e < 5; e++) {
            for (int j = 0; j < wheels[e].wedgeCount; j++) {
                get<0>(wheels[e].wedges[j]) += wheels[e].speed;
                get<0>(wheels[e].wedges[j]) %= 360;
            }
        }
    }

    cout << "none" << endl;

    return 0;
}