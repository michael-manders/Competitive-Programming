import java.util.*;
import java.lang.*;
import java.io.*;

public class chop {
    public static void main(String[] args) {

        // code here
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int n = Integer.parseInt(sc.nextLine());
        for(;n>0;n--)
        {   
            count = 0;
            int size = sc.nextInt();
            sc.nextLine();
            String[] wavess = sc.nextLine().trim().split(" ");
            Integer[] waves = new Integer[wavess.length];
            int i = 0;
            // System.out.println(Arrays.toString(wavess));
            for (String s: wavess) {
                waves[i] = Integer.parseInt(wavess[i]);
                i++;
            }

            for(i = 1; i <= waves.length-2; i++)
            {
                if(waves[i] > waves[i-1] && waves[i] > waves[i+1])
                {
                    // System.out.println(i + " " + "--");
                    count++;
                }
            }
            System.out.println(count);
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
