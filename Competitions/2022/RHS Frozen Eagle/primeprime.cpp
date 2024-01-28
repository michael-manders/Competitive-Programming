#include <bits/stdc++.h>
#include <ext/pb_ds/assoc_container.hpp>
#include <ext/pb_ds/tree_policy.hpp>

using namespace __gnu_pbds;

#define ll long long
#define all(v) v.begin(),v.end()
#define F_OR(i, a, b, s) for (int i=(a); (s)>0?i<(b):i>(b); i+=(s))
#define F_OR1(e) F_OR(i, 0, e, 1)
#define F_OR2(i, e) F_OR(i, 0, e, 1)
#define F_OR3(i, b, e) F_OR(i, b, e, 1)
#define F_OR4(i, b, e, s) F_OR(i, b, e, s)
#define GET5(a, b, c, d, e, ...) e
#define F_ORC(...) GET5(__VA_ARGS__, F_OR4, F_OR3, F_OR2, F_OR1)
#define FOR(...) F_ORC(__VA_ARGS__)(__VA_ARGS__)
#define forEach(x, a) for(auto& x: a)
#define umap unordered_map
#define uset unordered_set
#define pb(x) push_back(x)
#define ms(b,v) memset(b,v,sizeof(b))

const int MOD = 1e9+7;
const ll INF = 1e18;

template<class T>
using oSet = tree<T, null_type, std::less<T>,rb_tree_tag, tree_order_statistics_node_update>;

std::vector<int> sieve(int n) {
    std::vector<int> v;
    bool b[n+1];
    ms(b,true);
    for(int i = 2;i*i<n;i++) {
        for(int j = i * i; j < n;j+=i) {
            b[j] = false;
        }
    }
    if(n > 2) v.pb(2);
    FOR(i,3,n,2) if(b[i]) v.pb(i);
    return v;
}
int main() {
    int n;
    scanf("%d",&n);
    std::vector<int> t = sieve(3 * pow(10,7));
    ll count = 0;
    FOR(i,n) count += t[t[i]];
    printf("%lld",count);
    return 0;
}