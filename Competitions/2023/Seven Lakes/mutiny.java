import java.util.*;
import java.lang.*;
import java.io.*;

public class mutiny {
    public static void main(String[] args) {

        Kattio io = new Kattio();
        int N = io.nextInt();
        int M = io.nextInt();

        // io.nextLine();
        String[] pirates = io.nextLine().strip().split(" ");
        String[] swords = io.nextLine().strip().split(" ");

        int sum = 0;
        int i = 0;
        while (true) {
            if (i == pirates.length) break;
            if (M - Integer.parseInt(pirates[i]) < 0) break;
            else {
                M -= Integer.parseInt(pirates[i]);
                sum += Integer.parseInt(swords[i]);
                i++;
            }
        }

        System.out.println(Integer.MAX_VALUE > Math.pow(10, 9));

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
