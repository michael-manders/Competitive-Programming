#include <bits/stdc++.h>
using namespace std;

const int MAXN = 200005;

int possible[MAXN];
vector<string> prefixes;
string sequence;

int main() {
    ifstream inp("prefix.in");
    ofstream out("prefix.out");

    vector<string> prefixes;
    string seq, line;
    bool seqStart = false;
    while (inp >> line) {
        if (line == ".") {
            seqStart = true;
        }
        else if (!seqStart) {
            prefixes.push_back(line);
        }
        else {
            seq += line;
        }
    }

    int n = seq.size();
    vector<bool> possible(n + 1, false);
    possible[0] = true;
    int maxlen = 0;
    for (int i = 0; i <= n; i++) {
        for (const auto& prefix : prefixes) {
            int len = prefix.size();
            if (i >= len && seq.substr(i - len, len) == prefix && possible[i - len]) {
                possible[i] = true;
                maxlen = max(maxlen, len);
            }
        }
    }

    out << maxlen << endl;

    inp.close();
    out.close();
    return 0;
}
