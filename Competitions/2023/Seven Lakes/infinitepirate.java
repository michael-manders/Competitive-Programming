import java.util.*;
import java.lang.*;
import java.io.*;

public class infinitepirate {
    public static void main(String[] args) {

        Kattio io = new Kattio();

        int N = io.nextInt();

        HashSet<Character> vocab = new HashSet<>();
        for (char c: "argh matey".toCharArray()) {
            vocab.add(c);
        }

        while (N-->0) {
            String in = io.nextLine();
            HashSet<Character> word = new HashSet<>();
            for (char c: in.toLowerCase().toCharArray()) {
                word.add(c);
            }

            for (char c: vocab) {
                word.remove(c);
            }

            if (word.size() > 0) { 
                System.out.println("No");
            }
            else {
                System.out.println("Yes");
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
