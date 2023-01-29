import java.util.*;
import java.io.*;
import java.net.SocketTimeoutException;

class candy {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("candy");
        int N = io.nextInt();
        while (N > 0) {
            N--;

            int n = io.nextInt();
            int s = io.nextInt();

            ArrayList<Integer> bags = new ArrayList<>();
            int max = 0;
            int max2 = 0;
            for (int i = 0; i < n; i++) {

                int b = io.nextInt();
                if (b > max) {max2 = max; max = b;}
                else if (b > max2) {max2 = b;}
            }

            int maxSum = max + max2;
            max = 0;
            // HashSet<Integer> addends = new HashSet<Integer>();
            for (int a1 = maxSum / 2; a1 > 0; a1--) {
                for (int a2 = maxSum / 2; a2 > 0; a2--) {
                    if ((a1 + a2) % s == 0) {
                        if (a1 + a2 > max) {
                            int i1 = bags.indexOf(a1);
                            int i2 = bags.lastIndexOf(a2); 
                            if (i1 > -1 && i2 > -1 && i1 != i2) {
                                max = a1 + a2;
                            }
                        }
                    }
                }
            }

            System.out.println(max / s);

        }
        io.close();
    }
}

class Kattio extends PrintWriter {
    private BufferedReader r;
    private StringTokenizer st;
    // standard input
    public Kattio() { this(System.in,System.out); }
    public Kattio(InputStream i, OutputStream o) {
        super(o);
        r = new BufferedReader(new InputStreamReader(i));
    }
    // USACO-style file input
    public Kattio(String problemName) throws IOException {
        super(problemName+".out");
        r = new BufferedReader(new FileReader(problemName+".in"));
    }
    // returns null if no more input
    public String next() {
        try {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(r.readLine());
            return st.nextToken();
        } catch (Exception e) {}
        return null;
    }
    public int nextInt() { return Integer.parseInt(next()); }
    public double nextDouble() { return Double.parseDouble(next()); }
    public long nextLong() { return Long.parseLong(next()); }
}