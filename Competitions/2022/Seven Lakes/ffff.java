import java.util.*;
import java.io.*;

class ffff {
    public static void main(String []args) {
        Kattio io = new Kattio();

        int n = io.nextInt();
        while (n--  > 0) { 
            int m = io.nextInt(), l = io.nextInt(), k = io.nextInt(), wetTime = 0;
            while (m-- > 0) { 
                int depth = io.nextInt();
                if (depth > l) wetTime++;
                if (wetTime > k) break;
            }
            if (wetTime > k) io.println("No");
            else io.println("Yes");
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