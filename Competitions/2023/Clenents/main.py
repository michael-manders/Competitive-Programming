import os

template = open("template.java").read()

for name in os.listdir("./testcases"):
    name = name.split(".")[0]
    file = template.replace("template", name)
    open(f'{name}.java', "w").write(file)

