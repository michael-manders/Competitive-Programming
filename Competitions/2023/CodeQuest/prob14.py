from datetime import datetime, timedelta

for _ in range(int(input())):
    date, time, offset = input().split()
    m, d, y = map(int, date.split("/"))
    h, mi = map(int, time.split(":"))
    d = datetime(y, m, d, h, mi)    
    dd = timedelta(hours=float(offset))
    # print(d)
    out = d - dd
    print(f'{str(out.month).rjust(2, "0")}/{str(out.day).rjust(2, "0")}/{str(out.year).rjust(2, "0")} {str(out.hour).rjust(2, "0")}:{str(out.minute).rjust(2, "0")}')