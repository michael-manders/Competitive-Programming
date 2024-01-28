def shoelace_formula(polygonBoundary, absoluteValue = True):
    nbCoordinates = len(polygonBoundary)
    nbSegment = nbCoordinates - 1

    l = [(polygonBoundary[i+1][0] - polygonBoundary[i][0]) * (polygonBoundary[i+1][1] + polygonBoundary[i][1]) for i in range(nbSegment)]

    if absoluteValue:
        return abs(sum(l) / 2.)
    else:
        return sum(l) / 2.


boundery = ((0, 0), (1,3), (8, 4), (7, 3), (5, 3), (4, 0))
area = shoelace_formula(boundery)
volume_l = 3
cubic_cm = volume_l * 1000
height = cubic_cm / area
print(area, height)