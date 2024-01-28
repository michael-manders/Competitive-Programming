import java.util.*;
import java.lang.*;
import java.io.*;

public class crewmorale {
    public static void main(String[] args) {

        Kattio io = new Kattio();

        int N = io.nextInt();
        while (N --> 0) {
            double tot = io.nextDouble();
            double num = io.nextDouble();
            double qual = io.nextDouble();

            io.printf("%.2f\n", (double)Math.round((Math.pow(tot, 2) / Math.sqrt(num) + qual) * 100) / 100.);
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
