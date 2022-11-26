import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> board =  new ArrayList<>();
        for (int i = 0; i< 4; i++) {
            board.add(new ArrayList<>());
        }
        
        for (int i = 0; i < 16; i++) {
            int y = i / 4;
            board.get(y).add( Integer.parseInt(s.next()));
        }   
        System.out.println(board);

        ArrayList<ArrayList<Integer>> blank = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            int y = i/ 4;
            board.get(y).add(0);
        }

        

        int direction = s.nextInt();
        System.out.println(run(board, 0));
    }

    public static ArrayList<ArrayList<Integer>> run(ArrayList<ArrayList<Integer>> board, int direction) {
        
        ArrayList<ArrayList<Integer>> newBoard = left(board);
        if (direction == 1) {
            newBoard = rotate90(newBoard);
            newBoard = left(newBoard);
            newBoard=  left(newBoard);  
            newBoard = left(newBoard);
            newBoard=  left(newBoard);
            newBoard = rotate90(rotate90(rotate90(newBoard)));
        }
        if (direction == 0) {
            newBoard = left(newBoard);
            newBoard=  left(newBoard);  
            newBoard = left(newBoard);
            newBoard=  left(newBoard);
        }

        
        
        return newBoard;


    }

    public static ArrayList<ArrayList<Integer>> left(ArrayList<ArrayList<Integer>> board) {
        ArrayList<ArrayList<Integer>> b = new ArrayList<>(board);
        ArrayList<ArrayList<Integer>> newBoard = new ArrayList<>();
        
        for (ArrayList<Integer> row: b) {
            for (int i = 1; i < 4; i++) {
                if (row.get(i).equals(row.get(i-1)) || row.get(i-1) == 0) {
                    row.set(i-1, row.get(i) + row.get(i - 1));
                    row.set(i, 0);
                };
                
            }
            newBoard.add(row);
        }
        return newBoard;
    }

    public static ArrayList<ArrayList<Integer>> rotate90 (ArrayList<ArrayList<Integer>> before) {
        int n = before.size();
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>(before);
        for (int i = 0; i< n / 2; i++) {
            for (int j = i; j<n-i-1; j++) {
                int temp = arr.get(i).get(j); 
                arr.get(i).set(j, arr.get(n - 1 - j).get(i));
                arr.get(n - 1-  j).set(i, arr.get(n - 1 - i).get(n - 1 - j));
                arr.get(n - 1 - i).set(n - 1 - j, arr.get(j).get(n - 1 - i));
                arr.get(j).set(n - 1 - i, temp);
            }
        }

        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        for (ArrayList<Integer> row: arr) {
            output.add(new ArrayList<>(row.subList(0, 4)));
        }
        // System.out.println(output);
        return output;
    }

}
