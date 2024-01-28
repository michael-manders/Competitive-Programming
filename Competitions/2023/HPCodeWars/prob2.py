count = 0 
while(count == 0):
    num = int(input())
    if num == 0:
        count = count + 1
    elif(num % 4 == 0):
        print(str(num) + "/4 = " + str(int(num/4)))