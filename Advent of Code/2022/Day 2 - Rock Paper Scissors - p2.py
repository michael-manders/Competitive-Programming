print(sum([["B X", "C X", "A X", "A Y", "B Y", "C Y", "C Z", "A Z", "B Z"].index(x.replace("\n", '')) + 1 for x in open("in.in").readlines() ]))
