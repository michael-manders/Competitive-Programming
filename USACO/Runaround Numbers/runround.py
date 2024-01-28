"""
ID: mjmande1
PROG: runround
LANG: PYTHON3
"""

fin = open ('runround.in', 'r')
fout = open ('runround.out', 'w')

N = int(fin.readline())

def findIndex(l, n):
    if (n > l) :
        return ((n + 0) % (l ) ) 
    if (n < l and n > -1): return n
    if n == l: return 0


def check(n):
    passed = []
    s = [int(i) for i in [*str(n)]]
    start = s[0]

    while len(passed) < len(s):
        if start in passed: return False

        passed.append(start)
        index = s.index(start)  + start
        
        start = s[findIndex(len(s), index)]
        previous = start

    if not previous == s[0]: return False
    if not len(passed) == len(set(passed)): return False
    
    return True

N += 1
while "0" in str(N) or not check(N):
    N+=1
    



fout.write(f'{N}\n')
print(N)
# print('-----')
# print(check(142))
# print(findIndex(3, 4 + 1))
