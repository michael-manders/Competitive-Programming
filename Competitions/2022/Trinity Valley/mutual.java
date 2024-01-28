import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

class mutual {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        int p = io.nextInt();
        for (int N = 0; N < p; N++)  {
            int n = io.nextInt();
            int m = io.nextInt();

            ArrayList<Integer> ceo = new ArrayList<Integer>();
            ArrayList<Integer> me = new ArrayList<Integer>();

            for (int i = 0; i < m; i++) {
                int u = io.nextInt();
                int v = io.nextInt();

                // System.out.println(u + " " + v);
                
                if (u == 1) ceo.add(v);
                if (v == 1) ceo.add(u);
                if (u == n) me.add(v);
                if (v == n) me.add(u);
            }

            // System.out.println(ceo);
            // System.out.println(me);

            ArrayList<Integer> moots = new ArrayList<Integer>();

            for (int f: ceo) {
                if (me.contains(f)) {
                    moots.add(f);
                }
            }
            System.out.println(moots.size());
            for (int moot: moots) System.out.println(moot);
            System.out.println();

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
    // implement next line feature
    public String nextLine() {
        String output = "";
        while (true) {
            String n = this.next();
            if (n == null || n.equals("\n")) {
                break;
            }
            output += n + " ";
        }
        return output;
    }
}

