"""
ID: mjmande1
LANG: PYTHON3
TASK: gift1
"""

fin = open('gift1.in', 'r')
fout = open('gift1.out', 'w')

num = int(fin.readline())

values = {}

for i in range(num):
    values[fin.readline().replace("\n", "")] = 0


def run():
    try:
        giver = fin.readline().replace("\n", "")
        amount, num = fin.readline().replace("\n", "").split()
    except:
        return
    num = int(num)
    amount = int(amount)

    names = []
    for i in range(num): 
        name = fin.readline().replace("\n", "")
        if len(name) >= 1:

            names.append(name)

    try: 
        per_person, keep = divmod(amount, len(names))
    except:
        per_person = keep = 0

    if len(names) != 0:
        for name in names:
            values[name] += per_person

        values[giver] += -amount + keep



    run()

run()


for name in values:
    fout.write(f'{name} {values[name]}\n')
