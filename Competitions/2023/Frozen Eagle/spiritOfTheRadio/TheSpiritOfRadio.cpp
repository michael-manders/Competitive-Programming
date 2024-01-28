#include <bits/stdc++.h>

constexpr size_t N = 2e5 + 5;

template<typename T>
struct BinaryIndexedTree {
    T array[N];

    void add(int i, T x) {
        for (; i < N; i += i & -i) array[i] += x;
    }

    T query(int i) {
        T ans = 0;
        for (; i > 0; i -= i & -i) ans += array[i];
        return ans;
    }
};

struct LinearBinaryIndexedTree {
    BinaryIndexedTree<int> linear;
    BinaryIndexedTree<long long> constant;

    void addOnRange(const int l, const int r, const int x) {
        linear.add(l, x);
        linear.add(r, -x);
        constant.add(l, -1LL * (l - 1) * x);
        constant.add(r, 1LL * (r - 1) * x);
    }

    long long query(const int i) {
        return 1LL * linear.query(i) * i + constant.query(i);
    }
} indexedTree;

int segMax[4 * N], segMax2[4 * N], segCount[4 * N];

void update(const int v) {
    segMax2[v] = -1;
    if (segMax[2 * v] == segMax[2 * v + 1]) {
        segMax[v] = segMax[2 * v];
        segCount[v] = segCount[2 * v] + segCount[2 * v + 1];
        segMax2[v] = std::max(segMax2[2 * v], segMax2[2 * v + 1]);
    } else {
        const int u = segMax[2 * v] > segMax[2 * v + 1] ? 2 * v : 2 * v + 1;
        segMax[v] = segMax[u];
        segCount[v] = segCount[u];
        segMax2[v] = std::max(segMax[u ^ 1], segMax2[u]);
    }
}

void pushdown(const int v) {
    for (const int u: {2 * v, 2 * v + 1}) {
        segMax[u] = std::min(segMax[u], segMax[v]);
    }
}

void init(const int v, const int tl, const int tr) { // NOLINT(*-no-recursion)
    if (tl == tr) {
        segMax[v] = tl;
        segCount[v] = 1;
        segMax2[v] = -1;
        return;
    }
    const int tm = (tl + tr) / 2;
    init(2 * v, tl, tm);
    init(2 * v + 1, tm + 1, tr);
    update(v);
}

void applyMin(const int v, const int tl, const int tr, const int k) { // NOLINT(*-no-recursion)
    if (segMax[v] <= k || tl > k) return;
    if (tr <= k && segMax2[v] <= k) {
        indexedTree.addOnRange(segMax[v] + 1, k + 1, segCount[v]);
        segMax[v] = k;
        return;
    }
    pushdown(v);
    int tm = (tl + tr) / 2;
    applyMin(2 * v, tl, tm, k);
    applyMin(2 * v + 1, tm + 1, tr, k);
    update(v);
}

void setValue(const int v, const int tl, const int tr, const int i, const int x) { // NOLINT(*-no-recursion)
    if (tl == tr) {
        indexedTree.addOnRange(segMax[v] + 1, x + 1, 1);
        segMax[v] = x;
        return;
    }
    pushdown(v);
    const int tm = (tl + tr) / 2;
    if (i <= tm) setValue(2 * v, tl, tm, i, x);
    else setValue(2 * v + 1, tm + 1, tr, i, x);
    update(v);
}

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);
    int n, q;
    std::cin >> n >> q;
    init(1, 1, n);
    indexedTree.linear.add(1, 1);

    while (q--) {
        int type;
        std::cin >> type;
        if (type == 1) {
            int i, x;
            std::cin >> i >> x;
            setValue(1, 1, n, i, x);
            applyMin(1, 1, n, i - 1);
        } else if (type == 2) {
            int l, r;
            std::cin >> l >> r;
            std::cout << indexedTree.query(r) - indexedTree.query(l - 1) << '\n';
        } else
            assert(0);
    }
}