import java.util.*;
import java.io.*;

class dryrun {
    public static void main(String [] args) throws IOException {
        Scanner in = new Scanner(new File("dryrun.in"));

        // code here

        int N = in.nextInt();
        int M = in.nextInt();

        int i = 0;

        in.nextLine();

        while (--M > 0) {
            i += in.nextLine().split(" ").length;
        }

        System.out.println(i);

    }
}

