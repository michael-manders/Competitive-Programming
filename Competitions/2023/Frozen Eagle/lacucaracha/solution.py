def count_bishop_moves(board):
    if not board or not board[0]:
        return 0
    
    rows, cols = len(board), len(board[0])
    total_moves = 0
    
    for i in range(rows):
        for j in range(cols):
            if board[i][j] == 1:
                # Count moves in all four diagonal directions
                total_moves += count_diagonal_moves(board, i, j, 1, 1)  # Top-right
                total_moves += count_diagonal_moves(board, i, j, 1, -1)  # Top-left
                total_moves += count_diagonal_moves(board, i, j, -1, 1)  # Bottom-right
                total_moves += count_diagonal_moves(board, i, j, -1, -1)  # Bottom-left
    
    return total_moves

def count_diagonal_moves(board, row, col, row_dir, col_dir):
    moves = 0
    rows, cols = len(board), len(board[0])

    while 0 <= row + row_dir < rows and 0 <= col + col_dir < cols:
        row += row_dir
        col += col_dir
        if board[row][col] == 0:
            moves += 1
        else:
            break

    return moves


g = [[0 for _ in range(8)] for _ in range(8)]
x, y = s = input().replace("(", "").replace(")", "").split(", ")

x = ["A", "B", "C", "D", "E", "F", "G", "H"].index(x)

g[int(y)-1][x] = 1

print(count_bishop_moves(g))