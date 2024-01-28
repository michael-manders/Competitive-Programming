import java.util.*;
import java.lang.*;
import java.io.*;

public class cannonballrun {
    public static void main(String[] args) {

        // code here
        Scanner sc = new Scanner(System.in);
        int total = 0;
        int order = 0;
        int n = sc.nextInt();
        for(;n>0;n--)
        {
            total = 0;
            order = 0;
            int c = sc.nextInt();
            int cap = sc.nextInt();
            sc.nextLine();
            String[] temp = sc.nextLine().trim().split(" ");
            Integer[] cannons = new Integer[temp.length];
            int i = 0;
            for (String s: temp ) {
                cannons[i] = Integer.parseInt(temp[i]);
                i++;
            }
            int price = sc.nextInt();
            int balls = sc.nextInt();
            sc.nextLine();
            for(i = 0; i<cannons.length; i++)
            {
                if(cannons[i] < cap)
                {
                    order += cap - cannons[i];
                }
            }
            for(i = 0; order>i ;i+=balls)
            {
                total+= price;
            }
            System.out.println(total + " coins");

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
