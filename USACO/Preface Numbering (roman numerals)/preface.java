/* 
ID: mjmande1
LANG: JAVA
TASK: preface
*/

import java.util.*;
import java.io.*;

public class preface {
    public static void main(String []args) throws IOException {
        Kattio io = new Kattio("preface");
        
        int N = io.nextInt();
        String[] order = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        HashMap<String, Integer> counter = new HashMap<>();
        while (N > 0) {
            String s = toRomanNumeral(N);
            for (String c: s.split("")) {
                if (counter.containsKey(c)) counter.put(c, counter.get(c) + 1);
                else counter.put(c, 1);
            }
            
            N--;
        }

        for (int i = order.length - 1; i >= 0; i--) {
            if (counter.containsKey(order[i])) {
                System.out.println(order[i] + " " + counter.get(order[i]));
                io.println(order[i] + " " + counter.get(order[i]));
            }
        }

        io.close();
    }

    public static String toRomanNumeral(int num) {
        HashMap<String, Integer> numerals = new HashMap<String, Integer>();
        numerals.put("I", 1);
        numerals.put("IV", 4);
        numerals.put("V", 5);
        numerals.put("IX", 9);
        numerals.put("X", 10);
        numerals.put("XL", 40);
        numerals.put("L", 50);
        numerals.put("XC", 90);
        numerals.put("C", 100);
        numerals.put("CD", 400);
        numerals.put("D", 500);
        numerals.put("CM", 900);
        numerals.put("M", 1000);
        String[] order = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        String output = "";
        while (num > 0) {
            for (String n: order) {
                if (numerals.get(n) <= num) {
                    output+=n;
                    num-=numerals.get(n);
                    break;
                }
            }
        }
        return output;
    }

    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        public Kattio() { this(System.in, System.out); }
        public Kattio(InputStream in, OutputStream out) { super(out); r = new BufferedReader(new InputStreamReader(in)); };
        public Kattio(String name) throws IOException { super(name + ".out"); r = new BufferedReader(new FileReader(name + ".in")); }
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens()) 
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) { return null; }
        }

        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
        public String nextLine() {
            if (st != null && st.hasMoreTokens()) 
            { String out = ""; while (st.hasMoreTokens()) out += st.nextToken() + ' '; return out; }
            try { return r.readLine(); } catch (Exception e) { return null; }
        }
    }
}
