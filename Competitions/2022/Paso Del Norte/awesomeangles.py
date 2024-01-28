n = int(input())
for i in range(n):
    t = float(input())
    i = 3
    while True:
        s = ((i - 2) * 180) / i
        if round(s) == round(t): 
            print(i)
            break;
        i+=1
            