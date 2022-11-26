import copy
from sys import maxsize

def decimalToBinary(n):  
    return bin(n).replace("0b", "")  


def genBoard(size, minChars):
    boards = []
    maxSize = "1"*size**2
    s = size**2
    maximum = int(maxSize, 2) + 1
    for i in range(int(maxSize, 2) + 1):
        
        string = decimalToBinary(i).rjust(s, "0")
        if (i % 100000 == 0):
            percent = i / maximum
            print("checked possible boards {0:.2f}%".format(percent * 100))
        if string.count("1") > minChars:

            t = []
            index = 0
            for i in range(size):
                row = []
                for x in range(size):
                    row.append(int(string[index]))
                    index += 1
                t.append(row)
            

            if (check_board(t, size)):
                print(f"New best board found! number of Xs: {string.count('1')}")
                minChars = string.count("1")  
                boards.append(t)
    return (minChars, boards[len(boards) - 1])


def check_board(board, size):
    val = True
    for y in range(size):
        for x in range (size - 2):
            if (board[y][x] == "0"): pass
            if board[y][x] == 1 and board[y][x+1] == 1 and board[y][x + 2] == 1: return  False
    
    for y in range(size - 2):
        for x in range (size):
            if board[y][x] == 1 and board[y+1][x] == 1 and board[y+2][x ] == 1: return  False

    for y in range(size - 2):
        for x in range(size - 2, size ):
            if board[y][x] == 1 and board[y+1][x-1] == 1 and board[y+2][x-2] == 1: return  False

    for y in range(size - 2):
        for x in range (size - 2):
            if board[y][x] == 1 and board[y+1][x+1] == 1 and board[y+2][x+2] == 1: return  False 

    return True


def numOfX(board):
    string = "".join(["".join(str(x)) for x in board])
    return string.count("1")    



size = 6
for e in range (3, 10):
    f = open("boards.txt", "a+")
    size, board = genBoard(e, (e**2)/2)
    f.write(str(e)+ " ")
    f.write(str(size) + " ")
    f.write(str(board) + " \n")
    f.close()
    print(size)
    print(board)


# highest = 0
# b = None

# for board in boards:
#     if check_board(board, size): 
#         if numOfX(board) > highest:
#             highest = numOfX(board)
#             b = board

# print(highest)
# print(b)