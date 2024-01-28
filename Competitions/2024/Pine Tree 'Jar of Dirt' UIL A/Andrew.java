import java.util.*;
import java.io.*;

class Andrew {
    public static void main(String [] args) throws IOException{
        Scanner in = new Scanner(new File ("andrew.dat"));

        String[] nums= {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};

        int T = in.nextInt();
        in.nextLine();
        while (T --> 0) {
            int n = in.nextInt();

            ArrayList<Integer> pass = new ArrayList<>();

            for (int i = 1; i < 10; i++) {
                if (n % i == 0) pass.add(i);

            }
            for (int a: pass) {
                System.out.print(nums[a] + " ");
            }
            System.out.println();
        }

    }
}