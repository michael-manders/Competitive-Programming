import re
print(sum([1 for l in [[int(i) for i in l] for l in [re.split("[,-]", l) for l in [l.replace("\n", '') for l in open("in.in").readlines()]]] if (l[0] <= l[2] and l[1] >= l[3]) or (l[0] >= l[2] and l[1] <= l[3])]))
