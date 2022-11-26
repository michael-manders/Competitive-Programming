import os

folder_name = input("Name of the folder > ")
project_name = input("Short name of the problem > ")
defaultID = "mjmande1"

string = f'/* \nID: mjmande1\nLANG: JAVA\nTASK: {project_name}\n*/\n\nimport java.io.*;\nimport java.util.*;\n\nclass {project_name} {"{"}\n\tpublic static void main (String[] args) throws IOException {"{"}\n\t\tPrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("{project_name}.out")));\n\t\tBufferedReader br = new BufferedReader(new FileReader("{project_name}.in"));\n\t\t\n\t\t\n\t{"}"}\n{"}"}'

path = f'./{folder_name}'
os.mkdir(path)
f = open(f'{path}/{project_name}.in', 'x')
f.close()
f = open(f'{path}/{project_name}.out', 'x')
f.close()
f = open(f'{path}/{project_name}.java', 'x')
f.write(string)
f.close()