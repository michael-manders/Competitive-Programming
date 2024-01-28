import java.util.*;
import java.io.*;

public class census {
    public static void main(String []args) {
        Kattio io = new Kattio();
        int t = io.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = io.nextInt();
            int q1 = io.nextInt(); 
            int q3 = io.nextInt();

            double lower = q1 - 1.5 * (q3 - q1);
            double upper = q3 + 1.5 * (q3 - q1);

            // System.out.println(upper + " " + lower);

            ArrayList<Integer> nums = new ArrayList<>();

            for (int e = 0; e< n; e++) {
                int num = io.nextInt();
                if (num > upper || num < lower) nums.add(num);
            }
            Collections.sort(nums);
            if (nums.size() == 0) io.println(-1);
            else {
                io.println(nums.toString().replaceAll("[\\[\\],]","" ));
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
