import java.util.*;
import java.io.*;

class Gerald {
    public static void main(String [] args) throws IOException{
        Scanner in = new Scanner(new File ("gerald.dat"));

        // code here
        int count=0;
        int small =9999;
        int large = 1000;
        int total =0;
        int x =0;
        while(in.hasNextInt()){
            count +=1;
            x= in.nextInt();
            if(x>large) large=x;
            if(x<small) small = x;
            total += x;
        }
        System.out.println("COUNT:"+ count);
        System.out.println("SMALLEST:"+ small);
        System.out.println("LARGEST:"+ large);
        System.out.printf("MEAN: %.1f", (double)((double)Math.round(((double)total / (double)count) * 10.) / 10.));

    }
}