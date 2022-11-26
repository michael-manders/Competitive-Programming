/* 
ID: mjmande1
LANG: JAVA
TASK: hamming
*/

import java.util.*;
import java.io.*;

public class hamming {
    public static void main(String []args) throws IOException {
        Kattio io = new Kattio("hamming");

        int N, B, D;
        N = io.nextInt();
        B = io.nextInt();
        D = io.nextInt();
        
        ArrayList<Integer> nums = new ArrayList<Integer>();
        int i = 0;
        while (nums.size() < N) {
            if (hammingDistance(nums, i, D) || i == 0) {
                nums.add(i);
            }
            i++;
        }
        i = 0;
        for (int num: nums) {
            if (i % 10 == 0 && i != 0) io.println();
            i++;
            io.print(num);
            if ((i) % 10 != 0 && i != nums.size()) io.print(" ");
        }
        io.println();
        io.close();
    }

    public static boolean hammingDistance(ArrayList<Integer> nums, int num, int D) {
        for (int n : nums) {
            if (Long.bitCount(n ^ num) < D) {
                return false;
            }
        }
        return true;
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
