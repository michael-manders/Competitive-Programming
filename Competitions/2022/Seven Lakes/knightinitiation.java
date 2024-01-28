import java.util.*;
import java.io.*;

public class knightinitiation {
    public static void main(String []args) {
        Kattio io = new Kattio();
        int t = io.nextInt();
        
        for (int k = 0; k < t; k++) {
            int n = io.nextInt();
            int x = io.nextInt();

            ArrayList<Integer> knights = new ArrayList<>();
            ArrayList<Boolean> friends = new ArrayList<>();
            
            int totalPow = 0;
            int friendsTotal = 0;
            // ArrayList<Integer> friends = new ArrayList<>();

            for (int i = 0; i < knights.size(); i++) {
            
            }

        }

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

