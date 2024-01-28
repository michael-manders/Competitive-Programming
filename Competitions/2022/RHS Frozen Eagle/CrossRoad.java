import java.util.*;
import java.io.*;

class CrossRoad {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int y = input.nextInt();
        int x = input.nextInt();

        int[] speeds = new int[x];
        for (int i = 0; i < speeds.length; i++) {
            speeds[i] = input.nextInt();
        }

        input.nextLine();

        int[] start = new int[2];
        int[] finish = new int[2];

        boolean[][] road = new boolean[y][x];
        
        for (int y1 = 0; y1 < y; y1++) {
            String line = input.nextLine();
            int x1 = 0;
            for (char character: line.toCharArray()) {
                
                if (character == '.' || character == 'H' || character == 'C') road[y1][x1] = true;
                else road[y1][x1] = false;
                if (character == 'H') {finish[0] = x1; finish[1] = y1;}
                else if (character == 'C') {start[0] = x1; start[1] = y1;}
                
                x1++;
            } 
        }

        Road street = new Road(road, speeds);
        int i = 0;
        ArrayList<int[]> moves = street.getMoves(start[0], start[1], i);
        i++;

        boolean finished = false;
        while (finished == false && i < 300) {
            ArrayList<int[]> temp = new ArrayList<int[]>();
            for (int[] move: moves) {
                temp.addAll(street.getMoves(move[0], move[1], i));
            }
            
            for (int[] move: temp) {
                if (move[1] == finish[1] && move[0] == finish[0]) {
                    finished = true;
                }
            }
            i++;
            moves = temp;
        }

        if (i == 300) {
            System.out.println("Connor won't make it :(");
        }
        else {
            System.out.printf("Connor can get to H.E.B. in %d step(s)!", i);
        }
    }
}

class Road {

    private boolean[][] road;
    private int[] speeds;
    private int x, y;
    private HashMap<Integer, boolean[][]> computed = new HashMap<Integer, boolean[][]>();

    public Road(boolean[][] r, int[] s) {
        road = r.clone();
        speeds = s.clone();
        x = road[0].length;
        y = road.length;
    }

    public boolean[][] get(int i) {
        if (computed.containsKey(i)) return computed.get(i);
        else {
            boolean[][] temp = new boolean[y][x];
            
            int y1 = 0;
            for (boolean[] row: road) {
                int x1 = 0; 
                for (boolean space: row) {

                    int newy = y1 + speeds[x1] * i;
                    while (newy >= y || newy < 0) {
                        if (newy >= y) newy = Math.abs(newy - y);
                        else if (newy < 0) newy = y + newy;
                    }

                    temp[newy][x1] = space; 

                    x1++;
                }
                y1++;
            }
            computed.put(i, temp);
            return temp;
        }
    }

    public ArrayList<int[]> getMoves(int x1, int y1, int i) {
        boolean[][] board = this.get(i + 1);
        boolean[][] board2 = this.get(i);
        int[][] moves = {
                    {0, -1},
            {-1, 0}, {0, 0}, {1, 0},
                    {0,  1}
        };

        ArrayList<int[]> possibleMoves = new ArrayList<int[]>();

        for (int[] move: moves) {
            try {

                int ymove = y1 + move[1];
                if (ymove < 0) ymove = board.length - 1;
                else if (ymove >= board.length) ymove = 0;

                int xmove = x1 + move[0];

                if (board[ymove][xmove] && board2[ymove][xmove]) {
                    int[] temp = {xmove, ymove};
                    possibleMoves.add(temp);
                }
                else if (board[ymove][xmove] && move[1] == speeds[x1]) {
                    int[] temp = {xmove, ymove};
                    possibleMoves.add(temp);
                }
                
            }
            catch (Exception e) {
                continue;
            }
        }
        return possibleMoves;
    }

    public void print(int i) {
        boolean[][] temp = this.get(i);
        for (boolean[] row: temp) {
            for (boolean car: row) {
                if (car) System.out.print(".");
                else System.out.print("X");
            }
            System.out.println("");
        }
    }
}
