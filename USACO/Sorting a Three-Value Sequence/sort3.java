/* 
ID: mjmande1
LANG: JAVA
TASK: sort3
*/

import java.util.*;
import java.io.*;

public class sort3 {
    public static void main(String []args) throws IOException {
        Kattio io = new Kattio("sort3");
        
        int n = io.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) list.add(io.nextInt());

        int ones = Collections.frequency(list, 1);
        int twos = Collections.frequency(list, 2) + ones;
        int threes = Collections.frequency(list, 3) + twos;

        int swaps = 0;

        for (int i = 0; i < list.size(); i++) {
            int val;
            if (i < ones) val = 1;
            else if (i < twos) val = 2;
            else val = 3;

            if (list.get(i) != val) {
                int index = list.lastIndexOf(val);
                Collections.swap(list, i, index);
                swaps++;
                
            }

        }


        io.println(swaps);

        io.close();
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
