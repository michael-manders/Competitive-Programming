import java.util.*;
import java.io.*;

class Stinky {
    public static void main(String [] args) throws IOException{
        Scanner in = new Scanner(new File ("Stinky.in"));

        HashMap<String, Integer> m = new HashMap<>();

        m.put("Sunday", 5);
        m.put("Monday", 4);
        m.put("Tuesday", 4);
        m.put("Wednesday", 4);
        m.put("Thursday", 4);
        m.put("Friday", 5);
        m.put("Saturday", 5);

        int i = 0;

        int N = in.nextInt();
        in.nextLine();
        while (N --> 0) {
            i += m.get(in.nextLine().strip());
        }
        System.out.println(i);

    }
}