"""
ID: mjmande1
LANG: PYTHON3
TASK: fact4
"""

import math

# fin = open("fact4.in", "r")

# N = int(fin.read().strip())
# out = str(math.factorial(N))


# reversed(out)
# out = out.replace("0","")[-1]


# fout = open("fact4.out", "w")

# fout.write(f'{out}\n')

open("fact4.out", "w").write(f'{str(math.factorial(int(open("fact4.in", "r").read())))[::-1].replace("0", "")[0]}\n')