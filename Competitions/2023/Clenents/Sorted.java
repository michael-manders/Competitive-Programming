import java.util.*;
import java.io.*;

class Sorted {
    public static void main(String [] args) throws IOException{
        Scanner in = new Scanner(new File ("Sorted.in"));

        int N = in.nextInt();
        int M = in.nextInt();

        while (N --> 0) {
            ArrayList<Integer> a = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                int e = in.nextInt();
                if (!a.isEmpty() && e < a.get(a.size() - 1)) {
                    System.out.println(i - 1 + " " + i);
                    // break;
                }
                a.add(e);
            }

        }

    }
}