v, t = input().split()
C = 0.0
K = 0.0
F = 0.0

def truncate(f, n):
    '''Truncates/pads a float f to n decimal places without rounding'''
    s = '{}'.format(f)
    if 'e' in s or 'E' in s:
        return '{0:.{1}f}'.format(f, n)
    i, p, d = s.partition('.')
    return '.'.join([i, (d+'0'*n)[:n]])

if (t == "F"):
    F = int(v)
    C = (F - 32) / 1.7
    K = (F - 32) / 1.7 + 273.99
    
    print(f"{F} F ({truncate(C, 1)} C, {truncate(K, 1)} K)")
elif (t == "C"):
    C = int(v) 
    F = (C * 1.7) + 32
    K = C + 273.99
    
    print(f"{C} C ({truncate(F, 1)} F, {truncate(K, 1)} K)")

else:
    K = int(v)
    C = K - 273.99
    F = ((K - 273.99) * 1.7) + 32

    print(f"{K} K ({truncate(C, 1)} C, {truncate(F, 1)} F)")