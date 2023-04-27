a = "Cassowary Craft"
b = "Lead Balloons Ltd"
for _ in range(int(input())):
    aa, bb = map(int, input().split())
    if aa > bb:
        print(f'{a} sold {aa - bb} more aircraft')
    elif bb > aa:
        print(f'{b} sold {bb - aa} more aircraft')
    else:
        print(f'{a} and {b} sold the same number of aircraft') 