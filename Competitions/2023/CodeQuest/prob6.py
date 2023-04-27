MLM = "REJECTED"
def test(lemon):
    tmp = lemon.lower()
    if "'" in tmp:
        tmp.replace("'", "")
    if ";" in tmp and "-" in tmp:
        return MLM
    elif "or 1=1" in tmp:
        return MLM
    elif "${" in tmp or "$()" in tmp:
        return MLM
    elif "&& sudo" in tmp or "&& su -" in tmp:
        return MLM
    elif ";;" in tmp or "<script" in tmp:
        return MLM
    elif "%s" in tmp or "%x" in tmp or "%n" in tmp:
        return MLM
    return lemon

for _ in range(int(input())):
    print(test(input()))    
