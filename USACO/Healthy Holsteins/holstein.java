/* 
ID: mjmande1
LANG: JAVA
TASK: holstein
*/

import java.util.*;
import java.io.*;

public class holstein {

    static int[][] scoops;
    static int[] required;
    static int V, G;
    public static void main(String []args) throws IOException {
        Kattio io = new Kattio("holstein");
        
        V = io.nextInt();
        required = new int[V];
        for (int i = 0; i < V; i++) {
            required[i] = io.nextInt();
        }

        G = io.nextInt();

        scoops = new int[G][V];
        String s = "";
        for (int i = 0; i < G; i++) {
            for (int e = 0; e < V; e++) {
                scoops[i][e] = io.nextInt();
            }
            s+="1";
        }

        int max = Integer.parseInt(s, 2);
        ArrayList<boolean[]> combosThatWork = new ArrayList<>();

        for (int i = 1; i <= max; i++) {
            s = Integer.toBinaryString(i);
            while (s.length() != G ) s = "0"+s;
            // System.out.println(s);
            boolean[] combo = new boolean[G];
            for (int e = 0; e < G ; e++) {
                if (s.charAt(e) == '1') combo[e] = true;
                else combo[e] = false;
            }

            if (check(combo)) combosThatWork.add(combo);

        }

        boolean[] best = new boolean[G];
        for (int i = 0; i < best.length; i++) best[i] = true;

        
        
        for (boolean[] combo: combosThatWork) {

            if (freuqency(combo) < freuqency(best)) {
                best = combo;
            }
            else if (freuqency(combo) == freuqency(best)) {
                String s1 = "";
                String s2 = "";
                for (boolean val: combo) {
                    s1= (val ? "1" : "0") + s1;
                }
                for (boolean val: best) {
                    s2= (val ? "1" : "0") + s2;
                }
                
                if (Integer.parseInt(s1, 2) < Integer.parseInt(s2, 2)) best = combo;

            }
        }

        int sum = 0;
        s = "";
        int i = 0;
        for (boolean val: best) {
            i++;
            if (val) {
                sum++;
                s+=" " + i;
            }
        }
        s = sum + s;
        System.out.println(s);
        io.println(s);
        io.close();
    }

    public static int freuqency(boolean[] c) {
        int sum = 0;
        for (boolean e: c) if (e) sum++;
        return sum;
    }

    public static boolean check(boolean[] combo) {
        int[] sums = new int[V];

        for (int i = 0; i < G; i++) {
            if (combo[i]) {
                for (int e = 0; e < V; e++) {
                    sums[e] += scoops[i][e];
                }
            }
        }
        boolean val = true;
        

        for (int i = 0; i < V; i++) {
            if (required[i] > sums[i]) val = false;
        }
        return val;
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
