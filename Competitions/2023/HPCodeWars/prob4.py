odd = input()
list = []
index = 0 
for i in input():
    if(i == odd):
        list.append(str(index))
    index += 1
if(len(list) > 1):
    print(odd + " is at index: " + list[-1])
else:
    print(odd + " is at index: " + list[0])

