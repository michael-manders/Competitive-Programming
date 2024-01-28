import java.util.*;
import java.io.*;

class Seating {
    public static void main(String [] args) throws IOException{
        Scanner in = new Scanner(new File ("Seating.in"));

        //code here
        int n = in.nextInt();
        in.nextLine();
        for(int i=0; i<n; i++){
            String sent = in.nextLine()+" will sit ";
            String rest = in.nextLine();
            char a = (char)(rest.charAt(0) + 32);
            sent += (a + rest.substring(1, rest.length())+".");
            System.out.println(sent);

        }
        
    }
}