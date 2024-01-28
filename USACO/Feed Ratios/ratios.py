"""
ID: mjmande1
LANG: PYTHON3
TASK: ratios
"""

fin = open ('ratios.in', 'r')
fout = open ('ratios.out', 'w')

# Read in the data
goal = [int(x) for x in fin.readline().split()]
mix1 = [int(x) for x in fin.readline().split()]
mix2 = [int(x) for x in fin.readline().split()]
mix3 = [int(x) for x in fin.readline().split()]

print(goal)
print(mix1)
print(mix2)
print(mix3)

min = 100*100*100
minABC = [0,0,0]

def gcd(a, b, c):
    if a == 0:
        return b
    return gcd(b % a, a, c)

works = False

for i in range(100):
    for j in range(100):
        for k in range(100):

            a = (mix1[0]*i + mix2[0]*j + mix3[0]*k) / goal[0]
            b = (mix1[1]*i + mix2[1]*j + mix3[1]*k) / goal[1]
            c = (mix1[2]*i + mix2[2]*j + mix3[2]*k) / goal[2]

            if (i==0 and j == 38 and k ==7):
                print(a,b,c)
            
            if a != 0:
                if (a==b or goal[0] == 0 or goal[1] == 0) and (a==c or goal[0] == 0 or goal[2] == 0):
                    works = True
                    print(i,j,k)
            

                
            fout.write(f'{i} {j} {k} {(a / goal[0])}')
            fout.close()
            exit(0)

           
fout.write('NONE')
fout.close()
