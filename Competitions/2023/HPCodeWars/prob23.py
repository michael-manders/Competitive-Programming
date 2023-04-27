toCorrect = input().split(" ")
input()
input()
input()
sss = input()
replacements = {l.split(":")[0] : l.split(":")[1].split(",") for l in sss.split(";")}
replacements = {x: replacements[x] + [x] for x in replacements.keys()}

dictionary = []
while True:
    i = input()
    if i == "ZZZZZ": break
    dictionary.append(i)


sentence = []


# print(replacements)
flag = False
for word in toCorrect:
    flag = False
    for i, letter in enumerate(word):
        for rep in replacements[letter.capitalize()]:
            # print(f'{word} {i} {word[:i] + rep.lower() + word[i+1:]}')
            if word[:i] + rep.lower() + word[i+1:] in dictionary:
                sentence.append(word[:i] + rep.lower() + word[i+1:])
                flag = True
                break
        if flag: break

print(" ".join(sentence))
"""
we fond autovorrect is oftrn wfong
QWERTYUIOP
ASDFGHJKL
ZXCVBNM
Q:W,S,A;W:Q,E,A,S,D;E:W,S,D,F,R;R:E,D,F,G,T;T:R,F,G,H,Y;Y:T,G,H,J,U;U:Y,H,J,K,I;I:U,J,K,L,O;O:I,K,L,P;P:O,L;A:Q,W,S,X,Z;S:W,Q,A,Z,X,C,D,E;D:E,W,S,X,C,V,F,R;F:R,E,D,C,V,B,G,T;G:T,R,F,V,B,N,H,Y;H:Y,T,G,B,N,M,J,U;J:U,Y,H,N,M,K,I;K:I,U,J,M,L,O;L:O,I,K,P;Z:A,S,X;X:Z,S,D,C;C:X,S,D,F,V;V:C,D,F,G,B;B:V,F,G,H,N;N:B,G,H,J,M;M:N,H,J,K,L
an
apple
autocorrect
branch
extra
fancy
find
great
is
it
often
right
we
wrong
ZZZZZ
"""