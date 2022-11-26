import re
n = int(input())
arr = []
for i in range(n):
    name = input().replace(":",'')
    s = "\n"
    temp = 'j'
    while(temp != ''):
        temp = input()
        s += temp
    if(re.search("stroud",s.lower()) != None and name.lower() != 'jester'): arr.append(name)
print(('Fungeon List:\n'+'\n'.join(arr)).strip())