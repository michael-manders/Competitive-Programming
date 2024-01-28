/*
ID: mjmande1
LANG: C++14
TASK: kimbits
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


#define CSTR(n) ((char*)(malloc(sizeof(char)*n)))
#define endl '\n'

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
    setIO("kimbits");   
    
    int N, L, I;
    cin >> N >> L >> I;

   int count = 1;
    int answer = 0;
    
    if (I == 1) {
        answer = 0;
    } else {
        for (int i = 1; i < pow(2, N); i++) {
            int ones = 0;
            string binStr = bitset<32>(i).to_string();
            for (char c : binStr) {
                if (c == '1') {
                    ones++;
                }
            }
            
            if (ones <= L) {
                count++;
                if (count == I) {
                    answer = i;
                    break;
                }
                
                int c = 0;
                int e = i;
                while (e & 1) {
                    c++;
                    e >>= 1;
                }
                
                if (count + (1 << c) <= I) {
                    i += (1 << c) - 1;
                    count += (1 << c) - 1;
                }
            } else {
                int c = 0;
                int e = i;
                while ((e & 1) == 0) {
                    c++;
                    e >>= 1;
                }
                
                i += (1 << c) - 1;
            }
        }
    }

    string binStr = bitset<32>(answer).to_string();
    string out = "";


    for (int i = 0; i < binStr.size(); i++) {
        if (binStr[i] == '1') {
            out += '1';
        } else {
            out += '0';
        }
    }

    out = out.substr(out.size() - N, out.size());

    cout << out << endl;

    return 0;
}