import mendeleev

number = int(input("How many percentages> "))
percentages = []
for i in range(number):
    element = input("Element > ")
    percentage = float(input("Percentage> "))
    percentages.append([element, percentage])

step2 = []
for elm in percentages:
    step2.append(elm[1] / mendeleev.element(elm[0]).mass)

step3 = []
minimum = min(step2)

for elm in step2:
    step3.append(round(elm/minimum*100)/100)

print("Here are numbers after devide by least:")
print(step3)
mul = int(input("Multiply by what> "))
step4 = []

for elm in step3:
    step4.append(round(elm * mul))

formula = ""
mass = 0
for i in range(number):
    print(f'{percentages[i][0]} -> {percentages[i][1]} -> {step2[i]} -> {step3[i]} -> {step4[i]}')
    num = (step4[i] == 1)
    formula+=f'{percentages[i][0]}{num}'.replace("False", str(step4[i])).replace("True", '')
    mass+=mendeleev.element(percentages[i][0]).mass * step4[i]


print(formula)
print(f'Mass: {mass}')
try:
    molarM = float(input("Molar mass> "))

    molecularF = ''

    mul = round(molarM / mass)
    for i in range(number):
        molecularF+=f'{percentages[i][0]}{step4[i]*mul}'
    print('Molecular formula: ' + molecularF)
    print(f'Multiple: {mul}')
except Exception:
    pass
