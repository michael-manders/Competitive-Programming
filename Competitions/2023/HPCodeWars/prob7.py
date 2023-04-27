while True:
    i = int(input())
    if i ==0: break

    toAdd = []
    if i % 5 == 0: toAdd .append( "FIZZ" )
    if i % 9 == 0: toAdd.append("FUZZ")

    out = str(i) +" " + " ".join(toAdd)
    if len(toAdd) == 2: out += "!"

    if (len(toAdd) != 0): print(out)