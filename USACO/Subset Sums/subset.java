/* 
ID: mjmande1
LANG: JAVA
TASK: subset
*/

import java.util.*;
import java.io.*;

public class subset {
    public static void main(String []args) throws IOException {
        Kattio io = new Kattio("subset");
        
        int N = io.nextInt();
        
        for (int o = 1; o < 40; o++) {
            N = o;
            int maxB = (int)Math.pow(2, N);

            int nums[] = new int[N];
            for (int i = 1; i <= N; i ++) {
                nums[i-1] = i;
            }
    
            int combos = 0;
        
            for (int i = 0; i < maxB; i++) {

                if (i % 100000 == 0 )System.out.println(o + " " +  i + " / " + maxB + " :: " +  (int)((float)i / maxB * 100));
    
                String s = Integer.toBinaryString(i);
                while (s.length() < N) {
                    s = "0" + s;
                }
    
                int s1 = 0;
                int s2 = 0;
    
                int e = 0;
                for (char c : s.toCharArray()) {
                    if (c=='1') s1+=nums[e];
                    else s2+=nums[e];
                    e++;
                }
    
                if (s1 == s2) combos++;
    
            }
            io.println(o + " " + combos);

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
