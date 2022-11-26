dishes = {}
good= []
bad = []

while True:
    inp = input()
    if (inp == ""): break
    food, action = inp.split(" is being ")
    
    if food in bad: continue

    # print(food, action)

    if food not in dishes:
        if action != "prepared": bad.append(food)
        else: dishes[food] = action
    
    else:
        if (action == "cooked" and dishes[food] != "prepared"): 
            bad.append(food)
            continue
        elif (action == "served" and dishes[food] != "cooked"): 
            bad.append(food)
            continue
        elif (action == "served" and dishes[food] == "cooked"):
            good.append(food)
            dishes[food] = action
            continue
            
        dishes[food] = action

for food in dishes:
    if dishes[food] != "served": 
        bad.append(food)

done = []

print("Complete")
good.sort()
for food in good: 
    if food not in done:
        print (food)
        done.append(food)
bad.sort()

print("Messed Up")
for food in bad: 
    if food not in done:
        print (food)
        done.append(food)
    

        