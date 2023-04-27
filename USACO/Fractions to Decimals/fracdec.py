"""
ID: mjmande1
LANG: PYTHON3
TASK: fracdec
"""

def fraction_to_decimal(numerator, denominator):
    if numerator % denominator == 0:
        return str(numerator // denominator) + '.0'
    
    res = []
    # handle sign 
    if numerator * denominator < 0:
        res.append('-')
    numerator, denominator = abs(numerator), abs(denominator)
    
    # store remainder as key and index as value in order to detect cycles 
    remainders_seen = {}
    quotient, remainder = divmod(numerator, denominator)
    res.append(str(quotient))
    res.append('.')
    
    while remainder != 0:
        if remainder in remainders_seen:
            # cycle detected
            idx = remainders_seen[remainder]
            res.insert(idx, '(')
            res.append(')')
            break
        remainders_seen[remainder] = len(res)
        quotient, remainder = divmod(remainder * 10, denominator)
        res.append(str(quotient))
        
    return ''.join(res)

with open("fracdec.in", "r") as fin, open("fracdec.out", "w") as fout:

    N, D = map(int, fin.readline().split())

    out = fraction_to_decimal(N, D)

    for i in range(0, len(out), 76):
        fout.write(out[i:i+76] + '\n')

    fout.close()
    fin.close()