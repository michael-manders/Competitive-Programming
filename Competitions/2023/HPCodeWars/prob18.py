v = input().lower()
words = []
while True:
    try:
        words.append(input())
    except:
        break

if (len(words) == 1):
    print(words[0])

elif (len(words) == 2):
    print(f' {v} '.join(words))

else:
    string = ', '.join(words)
    index = string.rfind(',')
    string = string[:index+1] + " "+v + string[index+1:]
    print(string)