i = 0
count = 0
base = int(input())
power = int(input())
while(count == 0):
    if(base**i == power):
        count += 1
        print(str(base) + "^" + str(i) + " = " + str(power))
    else:
        i += 1