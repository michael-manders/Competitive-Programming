import re
print(sum(list(reversed(sorted([sum(i) for i in [list(map(int, i)) for i in [list(filter(lambda x: x != '', a.split("$"))) for a in re.sub("[,,\[\] ']", "", str(["#" if l == "\n" else l.replace("\n", "$") for l in open("in.in").readlines()])).split("#") ]]])))[ : 3]))
