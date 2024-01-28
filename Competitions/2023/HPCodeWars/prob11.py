Fcars = 0 
Pcars = 0 
students = int(input())
if students % 4 ==0:
    Fcars = students / 4
else:
    temp = students % 4 
    Fcars = (students - temp) / 4
    Pcars += 1

if(Fcars != 0 and Pcars == 0):
    if(Fcars == 1):
        print("1 full car")
    else: 
        print(str(int(Fcars)) + " full cars")
elif(Fcars == 0 and Pcars != 0):
    if(Pcars == 1):
        print(str(int(Pcars)) + " partial car")
    else: 
        print(str(int(Pcars)) + " partial cars")
else:
    print(str(int(Fcars)) + " full car"+ ("s" if Fcars > 1 else "") + ", " + str(int(Pcars)) + " partial car" + ("s" if Pcars > 1 else ""))

