population = int(input())
limit = int(input())
growth = float(input())
years = int(input())

PPP = int(population * (1+growth) * years)

print("At the current rate of growth there will be " + str(PPP) + " ponies in " + str(years) + " years.")

if(PPP > limit):
    print("Celestia will need to add space for at least " + str(PPP - limit) + " ponies!")
else:
    print("Celestia won't need to add space yet!")