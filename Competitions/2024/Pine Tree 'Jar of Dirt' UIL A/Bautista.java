import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

class Bautista {
    public static void main(String [] args) throws IOException{
        Scanner in = new Scanner(new File ("bautista.dat"));

        // code here
        String v = "aeiou";

        int T = in.nextInt();
        in.nextLine();

        while (T --> 0) {
            String s = in.nextLine();
            for (char c: s.toCharArray()) {
                if (v.indexOf(""+c) > -1) {
                    System.out.print("OUCH!!!");
                }
                else System.out.print(""+c);
            }
            System.out.println();
        }

    }
}