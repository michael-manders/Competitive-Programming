"""
ID: mjmande1
PROG: ride
LANG: PYTHON3
"""
def getNumber(str):
	str = str.encode()
	result = 1
	for c in str:
		result *= c-64
	return result % 47

fin = open ('ride.in', 'r')
fout = open ('ride.out', 'w')

one = fin.readline().strip()
two = fin.readline().strip()

one = getNumber(one)
two = getNumber(two)

if(one == two):
	fout.write ("GO\n")    
else:
	fout.write ("STAY\n")    
fout.close()