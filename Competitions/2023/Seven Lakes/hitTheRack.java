import java.util.*;
import java.lang.*;
import java.io.*;

public class hitTheRack {
    public static void main(String[] args) {

        Kattio io = new Kattio();

        int N = io.nextInt();

        while (N-->0) {
            String[] a = io.next().split(":");
            String[] b = io.next().split(":");

            double time = Integer.parseInt(b[0]) + 1. * Integer.parseInt(b[1]) / 60.;
            double left = 12 - Integer.parseInt(a[0]) - Integer.parseInt(a[1]) / 60.;
            if (time + left >= 8) {
                System.out.println("getting the ZZZs");

            }
            else {
                System.out.println("gonna take a nap");
            }
        }

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
