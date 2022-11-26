def f(x,y,D={}):
 R=[i for i in range(2**x)if'111'not in bin(i)]
 for _ in[0]*y:D={(a,b):bin(a).count('1')+max(D.get((b,c),0)for c in R if(a&b|a>>2&b>>1|a*4&b*2)&c<1)for a in R for b in R}
 return max(D.values())

print(f(10, 10))