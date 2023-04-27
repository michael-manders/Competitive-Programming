/*
ID: mjmande1
LANG: C++
TASK: contact
*/
#include <bits/stdc++.h>
using namespace std;

#define ar array
#define ll long long
#define ld long double
#define sz(x) ((int)x.size())
#define all(a) (a).begin(), (a).end()

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
    setIO("contact");   

    int A, B, N;
    cin >> A >> B >> N;
    string s;

    while (cin) {
        string t;
        cin >> t;
        s += t;
    }

    
    map<string, int> m;
    for (int i = 0; i < sz(s); i++) {
        for (int j = A; j <= B; j++) {
            if (i + j > sz(s)) break;
            m[s.substr(i, j)]++;
        }
    }

    vector<pair<int, string>> v;
    vector<int> frequencies;
    for (auto& [key, value] : m) {
        frequencies.push_back(value);
        v.push_back({value, key});
    }

    map<int, vector<string>> e;

    for (pair<int, string> i: v) {
        e[i.first].push_back(i.second);
    }

    set<int> freqs(frequencies.begin(), frequencies.end());
    vector<int> freqs2(freqs.begin(), freqs.end());
    sort(freqs2.begin(), freqs2.end(), greater<int>());

    int count = 0;
    for (int f: freqs2) {

        if (count >= N) break;
        count++;
        cout << f << endl;
        vector<string> patterns = e[f];

        sort(patterns.begin(), patterns.end(), 
            [] ( string& lhs, string& rhs) {
                return lhs.size() == rhs.size() ?
                    lhs < rhs : lhs.size() < rhs.size();
            }
        );

        int onLine = 0;
        bool start = true;

        for (string pattern: patterns) {
            if (onLine == 6) {
                cout << endl;
                onLine = 0;
                start = true;
            }
            if (start) {
                cout << pattern;
                start = false;
            }
            else {
                cout << " " << pattern;
            }

            onLine++;
        }

        cout << endl;
    }

    return 0;
}