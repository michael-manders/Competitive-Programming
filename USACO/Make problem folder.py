import os

# print(os.getcwd())

folder_name = input("Name of the folder > ")
project_name = input("Short name of the problem > ")
language = input("Language > ").lower().replace("cpp", "c++")

languages = {
    "java": "JAVA",
    "c++": "CPP",
    "python": "PY"
}



defaultID = "mjmande1"

with open(f"./Tools/template.{languages[language].lower()}","r") as t:
    string = t.read()

string = string.replace("[id]", defaultID).replace("[name]", project_name).replace("[lang]", languages[language].replace("PY", "PYTHON3").replace("CPP", "C++")).replace("[name]", project_name).replace("template", project_name)

path = f'c:/Users/12144/Desktop/Code/Competitive-Programming/USACO/{folder_name}'
os.mkdir(path)
f = open(f'{path}/{project_name}.in', 'x')
f.close()
f = open(f'{path}/{project_name}.out', 'x')
f.close()
f = open(f'{path}/{project_name}.{languages[language].lower()}', 'x')
f.write(string)
f.close()
os.system(f'code "{path}"')