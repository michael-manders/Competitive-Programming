count = 0 
total = 0 
in1 = list(map(int, input().split("-")))
in2 = list(map(int, input().split("-")))
# print(in1)
name = input()
year = in1[0]
year2 = in2[0]
count = in1[1]
while(year != year2):
    if count == 12:
        year += 1
        count= 0 
    else: 
        count += 1 
        total += 1

print(str(name) + " is " + str(total + in2[1] - 1) + " months old")