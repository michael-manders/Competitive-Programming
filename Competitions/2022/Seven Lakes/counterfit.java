import java.util.*;
import java.io.*;

public class counterfit {
    public static void main(String []args) {
        Kattio io = new Kattio();
        int n = io.nextInt();
        for (int i = 0; i < n; i++) { 
            int c = io.nextInt();
            int l = io.nextInt();
            ArrayList<String> coins = new ArrayList<String>();
            for (int j = 0; j < c; j++) {
                String coin = "";
                for (int k =0; k < l; k++) {
                    coin += io.nextLine();
                }
                coins.add(coin);
            };

            ArrayList<Integer> counterfits = new ArrayList<Integer>();

            for (int j = 0; j < coins.size(); j++) {
                if (j == 0) {
                    if (!coins.get(j).equals(coins.get(j + 1)) && !coins.get(coins.size() - 1).equals(coins.get(j))) {
                        counterfits.add(j);
                    }
                }
                else if (j == coins.size() - 1) {
                    if (!coins.get(j).equals(coins.get(j - 1)) && !coins.get(j).equals(coins.get(0))) {
                        counterfits.add(j);
                    }
                }
                else {
                    if (!coins.get(j).equals(coins.get(j - 1)) && !coins.get(j).equals(coins.get(j + 1))) {
                        counterfits.add(j);
                    }
                }
            }
            for (int e: counterfits) {
                e++;
                io.printf("Sir, coin %d is a counterfeit!\n", e);
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
