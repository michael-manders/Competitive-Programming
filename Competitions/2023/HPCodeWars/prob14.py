while True:
    try:
        a, b = map(int, input().split(" ") )
        if a ==0 and b == 0:
            break;
    except:
        break;
    sequence = [0, 1, 1]

    for i in range(b + 40):
        sequence.append(sequence[-1] + sequence[-2] + sequence[-3])

    print(abs(sequence[a] - sequence[b]))