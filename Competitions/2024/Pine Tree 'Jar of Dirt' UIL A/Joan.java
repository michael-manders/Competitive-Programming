import java.util.*;
import java.io.*;

class Joan {
    public static void main(String [] args) throws IOException{
        Scanner in = new Scanner(new File ("joan.dat"));

        String s = "";
        while (in.hasNext()) {
            s+= " " + in.nextLine();
        }

        int count = s.split(" ").length;

        int totSize = 0;

        for (String word: s.split(" ")) {
            totSize += word.length();
        }

        System.out.printf("%d words with an average length of %d letters", count - 1, Math.round((double)totSize / (double)count));

    }
}