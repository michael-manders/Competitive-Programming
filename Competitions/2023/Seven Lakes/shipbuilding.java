import java.util.*;
import java.lang.*;
import java.io.*;

public class shipbuilding {
    public static void main(String[] args) {

        Kattio io = new Kattio();

        int T = io.nextInt();

        while (T-->0) {

            int X = io.nextInt();
            int A = io.nextInt();
            int B = io.nextInt();
            int C = io.nextInt();

            if (X <= A) System.out.println("Plastic");
            else if (X <= B) System.out.println("Wood");
            else if (X <= C) System.out.println("Metal");    


        }

        // code here

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
