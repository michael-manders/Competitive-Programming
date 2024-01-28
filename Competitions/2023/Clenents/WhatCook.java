import java.util.*;
import java.io.*;

class WhatCook {
    public static void main(String [] args) throws IOException{
        Scanner scan = new Scanner(new File ("WhatCook.in"));

        // code here
        int g = scan.nextInt();
        int t;
        for(int i =0; i<g; i++){
            t = scan.nextInt();
            if(t<165){
                System.out.println("It's Raw!!");
            }
            else{
                System.out.println("Very good chef.");
            }

        }

    }
}