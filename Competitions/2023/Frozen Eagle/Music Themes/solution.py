n = int(input())
notes = list(map(int, input().split()))

n -= 1
dist = [notes[i + 1] - notes[i] for i in range(n)]

ans = 0
for i in range(5, n):
    fplen = 0
    fnlen = 0
    bplen = 0
    bnlen = 0
    for j in range(i):
        if i + fplen < n and dist[i + fplen] == dist[j]:
            fplen += 1
        else:
            if fplen >= 4:
                ans = max(ans, fplen)
            fplen = 0

        if i + fnlen < n and dist[i + fnlen] == -dist[j]:
            fnlen += 1
        else:
            if fnlen >= 4:
                ans = max(ans, fnlen)
            fnlen = 0

        if i - bplen > j and dist[i - bplen] == dist[j]:
            bplen += 1
        else:
            if bplen >= 4:
                ans = max(ans, bplen)
            bplen = 0

        if i - bnlen > j and dist[i - bnlen] == -dist[j]:
            bnlen += 1
        else:
            if bnlen >= 4:
                ans = max(ans, bnlen)
            bnlen = 0

if ans == 0:
    print(0)
else:
    print(ans + 1)
