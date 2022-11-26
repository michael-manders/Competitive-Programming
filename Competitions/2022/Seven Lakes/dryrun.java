import java.util.*;
import java.io.*;

class dryrun {
    public static void main(String []args) {
        Kattio io = new Kattio();
        int n = io.nextInt();
        io.println(MathEx.primeFactors(n));

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


class Graph {
    private int v;
    private int[][] nodes;
    private List<List<Integer>> unWeighted;
    public Graph(int V) {
        this.v = V;
        nodes = new int[v][v];
        unWeighted = new ArrayList<>();
        for(int i = 0;i<v;i++) { 
            unWeighted.add(new ArrayList<>());
        }
    }
    public void addEdge(int src, int dest, int weight) {
        //remove bottom line to make unidirectional
        nodes[src][dest] = weight;
        nodes[dest][src] = weight;
    }
    public void addEdge(int src, int dest) {
        //remove bottom line to make unidirectional
        unWeighted.get(src).add(dest);
        unWeighted.get(dest).add(src);
    }
    @Override
    public String toString() {
        return Arrays.toString(nodes) + " " + unWeighted;
    }
}

class Point {
    private int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {return x;}
    public int getY() {return y;}
    @Override
    public String toString() {return x + " " + y;}
}


class MathEx {
    public static List<Integer> primeSieve(int n) {
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime,true);
        for(int i = 2;i * i <= n;i++) {
            if(prime[i] == true)
                for(int j = i * i; j <= n;j+=i) prime[j] = false;
        }
        List<Integer> primes = new ArrayList<>();
        if(n > 2) primes.add(2);
        for(int i = 3;i<prime.length;i+=2) if(prime[i]) primes.add(i);
        return primes;
    }
    public static List<Integer> primeFactors(int n) {
        List<Integer> primes = primeSieve(n);
        List<Integer> factors = new ArrayList<>();
        int pfIndex = 0, pF = primes.get(0);
        while(pF * pF <= n) {
            while(n % pF == 0) {
                n /= pF;
                factors.add(pF);
            }
            pF = primes.get(++pfIndex);
        }
        if(n != 1) factors.add(n);
        return factors;
    }
    public static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    public static int lcd(int a, int b) {
        return Math.abs(a * b) / gcd(a,b);
    }
}