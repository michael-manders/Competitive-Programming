import java.util.*;
import java.io.*;

class chaos {
    public static void main(String [] args) throws IOException{
        Scanner scan = new Scanner(new File ("chaos.in"));
        int exits = scan.nextInt();
        int officers = scan.nextInt();
        for (int i =1; i <= exits; i++){
            scan.nextInt();
            if(scan.nextInt()<officers){
                System.out.println(i);
                break;
            }

            
        }

        

    }
}