for _ in range(int(input())):
    total = []
    for i in range(int(input())):
        dif, num = input().split()
        num = int(num)
        if dif == "HIGH":
            total.append(num)
            total.append(num)
            total.append(num)
        elif dif == "MEDIUM":
            total.append(num)
            total.append(num)
        else:
            total.append(num)
    print(round(sum(total)/len(total)*10))
