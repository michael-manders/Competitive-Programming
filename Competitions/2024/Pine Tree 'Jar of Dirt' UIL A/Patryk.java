import java.util.*;
import java.io.*;

class Patryk {
    public static void main(String [] args) throws IOException{
        Scanner in = new Scanner(new File ("patryk.dat"));

        int n = in.nextInt();

        PriorityQueue<String> pq = new PriorityQueue<>();

        while (n --> 0) {
            String s = in.next();
            pq.add(reversed(s));
        }

        while (!pq.isEmpty()) {
            System.out.println(reversed(pq.poll()));
        }

    }
    static String reversed(String s) {
        Stack<String> ss = new Stack<>();
        for (char c: s.toCharArray()) {
            ss.push("" + c);
        }
        s = "";
        while (!ss.isEmpty()) {
            s+=ss.pop();
        }
        return s;
    }
}