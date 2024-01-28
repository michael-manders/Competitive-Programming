N = int(input())
t = 0

for _ in range(N):
    tn, td, bpm, m = map(int, input().replace("C", "4/4").replace("/", " ").split())
    t += (tn * m ) / bpm

s = t * 60
h = s // 60 // 60
m = s // 60 % 60
s = round(s % 60)

if s == 60:
    s = 0
    m += 1

if m == 60:
    m = 0
    h += 1
    

print(f'{int(h)} hours, {int(m)} minutes, {int(s)} seconds')