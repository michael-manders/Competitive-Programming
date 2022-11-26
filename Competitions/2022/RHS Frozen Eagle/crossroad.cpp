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

const int MOD = 1e9+7;
const ll INF = 1e18;

void setIO(string name = "", int prec = 2) { // lim prec = 15
    cin.tie(nullptr)->sync_with_stdio(0);
    cout << fixed << setprecision(prec); // use cout instead of print() or write()
    if (sz(name)) {
        freopen((name+".in").c_str(), "r", stdin);
        freopen((name+".out").c_str(), "w", stdout); 
    }
}

string to_string(char c) { return string(1, c); }
string to_string(bool b) { return b?"true":"false"; }
string to_string(const char* s) { return string(s); }
string to_string(string s) { return s; }
template<class T> string to_string(T v) {
    bool f=1;
    string res;
    EACH(x, v) {
        if(!f) res+=' ';
        f=0;
        res+=to_string(x);
    }
    return res;
}

template<class T> void read(T& x) { cin >> x; }
void read(double& d) { string t; read(t); d=stod(t); } // db & ld are special
void read(ld& d) { string t; read(t); d=stold(t); }
template<class H, class... T> void read(H& h, T&... t) { read(h); read(t...); }
template<class A> void read(vt<A>& x) { EACH(a, x) read(a); }

template<class A> void write(A x) { cout << to_string(x); }
template<class H, class... T> void write(const H& h, const T&... t) { write(h); write(t...); }
void print() { write("\n"); }
template<class H, class... T> void print(const H& h, const T&... t) { 
    write(h);
    if(sizeof...(t))
        write(' ');
    print(t...);
}

// task variables, funcs, definitions
#define N 125000005
#define MAXRC 500
#define MAXTIME 300

struct Node {
    int t, r, c;
    Node(int tt, int rr, int cc) { t = tt; r = rr; c = cc; }

    Node() { t = 0; r = 0; c = 0; }

    bool operator == (const Node& rhs) {
        return r == rhs.r && c == rhs.c;
    }
};

int r, c;
Node src, heb;
vt<int> v;
vt<vt<vt<int>>> road(MAXTIME, vt<vt<int>>(MAXRC, vt<int>(MAXRC, 0))); // [time][row][col]

int main() {
    setIO("");

    read(r, c);
    v.assign(c, 0);
    read(v);

    FOR(i, r) {
        string temp;
        read(temp);

        FOR(j, sz(temp)) {
            if (temp[j] == 'X') road[0][i][j] = MOD;
            if (temp[j] == 'C') { src.r = i; src.c = j; }
            if (temp[j] == 'H') { heb.r = i; heb.c = j; }
        }
    }

    // fill road

    FOR(k, 1, MAXTIME) {
        vt<vt<int>> newroad(MAXRC, vt<int>(MAXRC, 0));
        FOR(i, r) 
            FOR(j, c) 
                if (road[k-1][i][j] == MOD) newroad[(r+i+v[j])%r][j] = MOD;

        road[k] = newroad;
        
    }


    // bfs
    road[0][src.r][src.c] = 1;
    int time = -1;
    queue<Node> q;
    q.push(src);

    while (!q.empty()) {
        Node cur = q.front(); q.pop();

        if (cur == heb) { time = cur.t; break; }

        int dist = road[cur.t][cur.r][cur.c];

        vt<Node> nx;

        // yes this is messy, no i won't fix it

        if (v[cur.c] > 0) {
            nx.eb(cur.t+1, (cur.r+1)%r, cur.c);
            if (road[cur.t][(cur.r-1+r)%r][cur.c] != MOD) nx.eb(cur.t+1, (cur.r-1+r)%r, cur.c);
        } else if (v[cur.c] < 0) {
            nx.eb(cur.t+1, (cur.r-1+r)%r, cur.c);
            if (road[cur.t][(cur.r+1)%r][cur.c] != MOD) nx.eb(cur.t+1, (cur.r+1)%r, cur.c);
        } else {
            nx.eb(cur.t+1, (cur.r+1)%r, cur.c);
            nx.eb(cur.t+1, (cur.r-1+r)%r, cur.c);
        }

        if (cur.c-1 >= 0 && road[cur.t][cur.r][cur.c-1] != MOD) nx.eb(cur.t+1, cur.r, cur.c-1);
        if (cur.c+1 < c && road[cur.t][cur.r][cur.c+1] != MOD) nx.eb(cur.t+1, cur.r, cur.c+1);
        nx.eb(cur.t+1, cur.r, cur.c);



        EACH(x, nx) {
            if (x.t < MAXTIME && road[x.t][x.r][x.c] == 0) {
                q.push(x);
                road[x.t][x.r][x.c] = (x==cur?dist : dist+1);
                if (road[x.t-1][x.r][x.c] != 0) road[x.t][x.r][x.c] = min(road[x.t][x.r][x.c], road[x.t-1][x.r][x.c]);
            }
        }
    }
    
    if (time != -1) print("Connor can get to H.E.B. in", road[time][heb.r][heb.c]-1, "step(s)!");
    else print("Connor won't make it :(");

    return 0;
}
