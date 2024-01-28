import java.util.*;
import java.io.*;

class Coffee {
    public static void main(String [] args) throws IOException{
        Scanner in = new Scanner(new File ("Coffee.in"));

        // code here
        in.next();
        int num = in.nextInt();
        if(num == 8){
            System.out.println("Yes, you may use this version of Java for the contest!");
        }
        else{
            System.out.println("Please use a different version of Java.");
        }
    }
}