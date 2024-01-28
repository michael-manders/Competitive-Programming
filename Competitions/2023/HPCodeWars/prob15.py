from datetime import date

day, month, datee = input().split(" ")
year1, year2 = map(int, input().split("-"))


months = {
    "JAN": 0,
    "FEB": 1,
    "MAR": 2,
    "APR": 3,
    "MAY": 4,
    "JUN": 5,
    "JUL": 6,
    "AUG": 7,
    "SEP": 8,
    "OCT": 9,
    "NOV": 10,
    "DEC": 11
}

days = ["MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"]

datee = int(datee)
month = months[month]

for y in range(year1, year2):
    try:
        dateO = date(y, month + 1, datee)
        week = dateO.weekday()
        # print(y, week)
        if (days[week] == day):
            print(y)
    except:
        pass
    
