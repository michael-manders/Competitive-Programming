""" 
ID: mjmande1
LANG: PYTHON3   
TASK: prefix
"""

with open('prefix.in', 'r') as inp, open('prefix.out', 'w') as out:
    prefixes = []
    seq = ''
    seqStart = False
    for line in inp:
        line = line.strip()
        if line == '.':
            seqStart = True
            continue
        if not seqStart:
            prefixes.extend(line.split())
        else:
            seq += line

    dp = {i: [] for i in range(len(seq))}
    # sort prefixes by length
    prefixes.sort(key=lambda x: len(x), reverse=True)
    
    for i in range(len(seq)):

        for prefix in prefixes:
            # if the prefix matches that spot in the sequence add it to the dp list
            if seq[i:].startswith(prefix):
                dp[i].append(prefix)
                
                break
        

    possible = [False] * len(seq)
    for i in range(len(seq)):
        d = dp[i]
        maxLenInD = max([len(x) for x in d] + [0])
        if maxLenInD == 0:
            continue
        else:
            for j in range(i, i + maxLenInD):
                possible[j] = True

    # find the first false
    index = next((i for i, x in enumerate(possible) if not x), len(seq))
    print(index)
    out.write(str(index) + '\n')
