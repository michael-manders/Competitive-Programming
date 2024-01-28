import java.util.*;
import java.io.*;

class Curvy {
    public static void main(String [] args) throws IOException{
        Scanner in = new Scanner(new File ("Curvy.in"));

        int N = in.nextInt();

        while (N --> 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            
            if (Math.round(Math.sqrt(a) * 10) == 1. * b) System.out.println("square root");
            else System.out.println("cube root");

        }

    }
}