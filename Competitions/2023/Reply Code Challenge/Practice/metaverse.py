import math



for C in range(int(input())):
    nums, maxval = map(int, input().split(" "))
    numbers = list(map(int, input().split(" ")))

    arrays = []
    for _ in range(len(numbers)):
        arrays.append([0 for x in range(maxval)])

    for i, number in enumerate(numbers):
        for e in range(maxval):
            if e % number == 0:
                arrays[i][e] = 1
    
    final = 0

    for i in range(maxval):
        val = True
        for e in range(len(arrays)):
            if arrays[e][i] == 0:
                val = False
                break
        if val: final += 1

    print(arrays)    
    print(f'Case #{C} {final}')

    # write to output.txt (append mode)
    with open('output.txt', 'a') as f:
        f.write(f'Case #{C} {final}\n')
    


"""
1
2 94
2 2
"""