"""
ID: mjmande1
LANG: PYTHON3
TASK: zerosum
"""
import regex as re
fin = open('zerosum.in', 'r')
fout = open('zerosum.out', 'w')

def numberToBase(n, b):
    if n == 0:
        return "0"
    digits = []
    while n:
        digits.append(int(n % b))
        n //= b
    # digits = re.sub('[\[,\]\']', '', str(digits[::-1]))
    return  re.sub('[\[,\]\' ]', '', str(digits[::-1]))

chars = {
    "0": '+',
    "1": '-',
    "2": ' '
}

N = int(fin.readline())

baseStr = re.sub('[\[,\]\']', '', str([f'{i} ' for i in range(1, N + 1)])).strip().replace("  ", "#")
maxVal = int("1"+("0"*N), 3)

works = []


for i in range(maxVal):
    string = numberToBase(i, 3)
    while( len(string) < N): string = "0" + string
    toEval = baseStr
    for c in string:
        toEval = toEval.replace("#", chars[c], 1)
    

    if (eval(toEval.replace(" ", '')) == 0): works.append(toEval)

works = list(set(works))
works.sort()
for w in works: 
    print(w)
    fout.write(w+'\n')
fout.close()
fin.close()