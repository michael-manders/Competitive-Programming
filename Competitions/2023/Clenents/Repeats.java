import java.util.*;
import java.io.*;

class Repeats {
    public static void main(String [] args) throws IOException{
        Scanner in = new Scanner(new File ("Repeats.in"));

        // code here
        int N = in.nextInt();
        int M = in.nextInt();


        Queue<String> words = new LinkedList<>();
        HashMap<String, Integer> counts = new HashMap<>(); 
        

        in.nextLine();
        while (N --> 0) {
            String s = in.nextLine();
            counts.put(s, 0);
            words.add(s);
        }

        while (in.hasNext()) {
            String s = in.next();
            for (String k: counts.keySet()) {
                if (k.toLowerCase().equals(s.toLowerCase())) {
                    counts.put(k, counts.get(k) + 1);
                }
            }
        }

        // for (String k: counts.keySet()) {
        //     System.out.println(k + ": " + counts.get(k) + " times" );
        // }

        while (!words.isEmpty()) {
            String word = words.poll();
            System.out.println(word + ": " + counts.get(word) + " times");
        }
    }
}