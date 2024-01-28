import java.util.*;
import java.lang.*;
import java.io.*;

public class sendforthearmada {
    public static void main(String[] args) {

        // code here

        Kattio io = new Kattio();

        int N = io.nextInt();

        // System.out.println(952 % 26);

       

        while (N-->0) {
            String alph = "abcdefghijklmnopqrstuvwxyz";
            String newalph = "abcdefjhijklmnoqurstuvqxyz";
            int offset = io.nextInt();

            if (offset > 0) {
                while (offset --> 0) {
                    String temp = newalph.substring(25, 26) + newalph.substring(1, 25);
                    newalph = temp;
                }
            }

            if (offset < 0) {
                while (offset < 0) {
                    // System.out.println(offset);
                    String temp = newalph.substring(1, 26) + newalph.substring(0, 1);
                    newalph = temp;
                }
            }

            String word = io.nextLine();

            String output = "";

            System.out.println(newalph);

            for (char cc: word.toLowerCase().toCharArray()) {
                String c = "" + cc;
                if (alph.indexOf(c) != -1) {
                    output+=newalph.charAt(alph.indexOf(c));
                }
                else {
                    output += c;
                }
            }

            System.out.println(output.toUpperCase());

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
