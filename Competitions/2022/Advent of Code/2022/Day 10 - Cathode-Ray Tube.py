
clock = 0
value = 1

signal_strengths = {}
pixels = list("." * 40 * 6)

def draw(v, c, pix):
    pos = (c - 1) % 40
    if pos in {v-1, v, v+1}:
        pix[c - 1] = "#"

for ln in open("in.in").readlines():
    ln = ln.replace("\n", "")
    if "noop" in ln:
        clock+=1
        signal_strengths[clock] = value * clock
        draw(value, clock, pixels)
    elif "addx" in ln:
        clock+=1
        signal_strengths[clock] = value * clock
        draw(value, clock, pixels)
        clock+=1
        signal_strengths[clock] = value * clock
        draw(value, clock, pixels)
        value+=int(ln.split()[1])
        

s = 0
for i in range(20, 221, 40):
    # print(i, signal_strengths[i])
    s+=signal_strengths[i]
print(s)

for i in range(0 ,201, 40):
    print("".join(pixels[i:i+40]))
    
