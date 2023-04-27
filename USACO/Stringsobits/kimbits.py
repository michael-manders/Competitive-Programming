"""
ID: mjmande1
LANG: PYTHON3
TASK: kimbits
"""

import math

N, L, I = map(int, open("kimbits.in" , "r").read().split())
count = 1;
answer = 0;

if (I == 1):
    answer = 0;
else:
    for i in range(1, int(math.pow(2, N))):
        ones = bin(i).count('1');
        
        if (ones <= L):
            count += 1;
            if (count == I):
                answer = i;
                break;

            c = 0
            e = i;
            while e & 1:
                c += 1;
                e >>= 1;
            
            if (count +( 1<<c )<= I):
                i+=(1<<c) - 1;
                count += (1<<c) - 1;

        else:
            c=0;
            e = i;
            while e & 1 == 0:
                c += 1;
                e >>= 1;
            
            i += (1<<c) - 1;


answer = bin(answer)[2:]
# print()
    
print(answer)

# open("kimbits.out", "w").write()

