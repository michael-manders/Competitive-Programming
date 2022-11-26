import java.util.*;

public class kitchenSweeper {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        int y = input.nextInt();
        input.nextLine();

        int[][] outputBoard = new int[y][x];

        int[][] movements = {
            {-1, -1}, {0, -1}, {1, -1}, 
            {-1, 0} ,          {1, 0},
            {-1, 1} ,  {0, 1}, {1, 1}
        };

        for (int i = 0; i < y; i++) {
            String row = input.nextLine();
            for (int e = 0; e < x; e++) {
                char character = row.charAt(e);
                if (character == '*') {
                    outputBoard[i][e] = -1;
                    for (int[] move: movements) {
                        try {
                            if (outputBoard[i + move[1]][e + move[0]] > -1) outputBoard[i + move[1]][e + move[0]]++;
                        }
                        catch (Exception exep){
                            continue;
                        }
                    }
                }
            }
        }
        for (int[] row: outputBoard) {
            for (int character: row) {
                if (character == -1) System.out.print("*");
                else System.out.print(character);
            }
            System.out.print("\n");
        }
    }
}
