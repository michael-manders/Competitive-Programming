import java.util.*;
import java.io.*;

class Svetlana {
    public static void main(String [] args) throws IOException{
        Scanner in = new Scanner(new File ("svetlana.dat"));

        // code here
        int T = in.nextInt();
        in.nextLine();
        in.nextLine();

        int[][] board = new int[8][4];

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                String c = in.next();
                
                if (c.equals("r")) board[y][x] = 1;
                if (c.equals("R")) board[y][x] = 2;
                if (c.equals("b")) board[y][x] = 3;
                if (c.equals("B")) board[y][x] = 4;
            }
        }

        System.out.println(Arrays.deepToString(board));
    }
}