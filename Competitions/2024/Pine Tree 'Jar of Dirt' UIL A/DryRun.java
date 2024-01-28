import java.util.*;
import java.io.*;

class DryRun {
    public static void main(String [] args) throws IOException{
        int f = 0;
        for (int x = 1; x <= 10; x = x + 1) {
            f--;
            for (int y = 1; y <= x; y=y+1) {
                f++;
            }
        }
        System.out.println(f);

    }
}