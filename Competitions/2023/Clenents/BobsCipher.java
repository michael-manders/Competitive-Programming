import java.util.*;
import java.io.*;

class BobsCipher {
    public static void main(String [] args) throws IOException{
        Scanner in = new Scanner(new File ("BobsCipher.in"));

        String alph = "abcdefghijklmnopqrstuvwxyz";
        String newalph = "defghijklmnopqrstuvwxyzabc";

        int N = in.nextInt();

        in.nextLine();
        while (N-->0) {
            String out = "";
            String in_ = in.nextLine();

            for (char c: in_.toCharArray()) {
                out+=newalph.charAt(alph.indexOf(""+c));
            }
            System.out.println(out);

        }
        

    }
}