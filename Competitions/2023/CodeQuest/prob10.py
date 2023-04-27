for _ in range(int(input())):
    c = int(input())
    a = list(map(float, input().split()))
    b = list(map(float, input().split()))
    d = []
    for _ in range(c):
        d.append( b[_]- a[_])
    
    a, b = str(round(sum(d) / len(d), 2)).split(".")
    # b = "2"
    b = b.ljust(2, "0")
    
    print(f'{a}.{b}')