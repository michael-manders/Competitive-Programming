import java.util.*;
import java.io.*;

class Birdbrained {
    public static void main(String [] args) throws IOException{
        Scanner in = new Scanner(new File ("Birdbrained.in"));
        int num = in.nextInt();

        in.nextLine();
        int count = 0;
        for(int i = 0; i< num; i++){
            if(in.nextLine().indexOf("GOBBLE")>-1){
                count++;
            }
        }
        System.out.println(count);
        // code here

    }
}