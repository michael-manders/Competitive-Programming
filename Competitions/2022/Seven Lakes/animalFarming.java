import java.util.*;
import java.io.*;

public class animalFarming {
    public static void main(String []args) {
        Kattio io = new Kattio();
        int n = io.nextInt();

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            for (int j = 0; j < 4; j++) {
                tmp.add(io.nextInt());
            }
            
            if (tmp.get(0).equals(tmp.get(1)) && tmp.get(0).equals(tmp.get(2)) && tmp.get(0).equals(tmp.get(3))) {
                io.println("sheep");
            }
            else if (
                tmp.get(0).equals( tmp.get(2)) && tmp.get(1).equals(tmp.get(3))
            ) {
                io.println("cattle");
            }
            else {
                io.println("pigs");
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
