import java.util.*;

public class ticTacStubYourToe {
    public static void main(String[] args) {
        makeBest(5) ;
    }

    public static void makeBest(int size) {
        int minChars = size*size / 2;
        String best = "";
        String maxSize = "1".repeat(size*size);
        ArrayList<String> boards = new ArrayList<>();
        int s = size*size;
        long maximum = Long.parseLong(maxSize, 2) + 1;
        for (long i = 0; i < maximum; i++) {
            String string = Long.toBinaryString(i);
            string = "0".repeat(size*size - string.length()) + string;
            if (i % 300000 == 0) {
                System.out.printf("on board %d of %d || %f percent\n", i, maximum, ((float)i / maximum) * 100);
            }
            int n = count(string, "1");
            if (n > minChars && n < minChars + 8) {
                String regex = String.format("(?<=\\G.{%d})", size);
                String[] board = string.split(regex);
                
                if (checkBoard(board, size)) {
                    int num = count(string, "1");
                    System.out.printf("New best board found! Number of Xs: %d\n", num);
                    minChars = num;
                    boards.add(string);
                }

            }   
        }
        String regex = String.format("(?<=\\G.{%d})", size);
        for (String e: (boards.get(boards.size() - 1).split(regex))) {System.out.println(e.replace("1", "X").replace("0", "."));};
        
        System.out.println(minChars);
    }


    public static boolean checkBoard(String[] board, int size) {
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size - 2; x++) {
                if (board[y].charAt(x) == '1' && board[y].charAt(x + 1) == '1' && board[y].charAt(x + 2) == '1') return false;
                else if (board[y].charAt(x+2) == '0' && x + 3 < size - 2) x+=2;
            }
        }
        for (int y = 0; y < size - 2; y++) {
            for (int x = 0; x < size; x++) {
                if (board[y].charAt(x) == '1' && board[y + 1].charAt(x) == '1' && board[y + 2].charAt(x) == '1') return false;
                else if (board[y+2].charAt(x) == '0' && y + 3 < size - 2) y+=2;
            }
        }
        for (int y = 0; y < size - 2; y++) {
            for (int x = 0; x < size - 2; x++) {
                if (board[y].charAt(x) == '1' && board[y + 1].charAt(x + 1) == '1' && board[y +2 ].charAt(x + 2) == '1') return false;
            }
        }
        for (int y = 0; y < size - 2; y++) {
            for (int x = 2; x < size; x++) {
                if (board[y].charAt(x) == '1' && board[y + 1].charAt(x - 1) == '1' && board[y +2].charAt(x - 2) == '1') return false;
            }
        }

        return true;
    }


    public static int count(String str, String target) {
        return (str.length() - str.replace(target, "").length()) / target.length();
    }

}

