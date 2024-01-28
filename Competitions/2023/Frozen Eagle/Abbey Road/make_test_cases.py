import random

def update_m():
    grid = [[1 if x > .97 else 0 for x in y] for y in [[random.random() for x in range(250)] for y in range(250)]]

    gridString = "\n".join(["".join([str(y) for y in x]) for x in grid])

    speeds = " ".join([str(random.randint(1, 250)) for x in range(250)])

    out = "250 250\n" + speeds + "\n" + gridString

    f = open("abby.txt", "w")
    f.write(out)