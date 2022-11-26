import java.util.*;
import java.io.*;

public class royalSactrafice {
    public static void main(String []args) {
        Kattio io = new Kattio();
        int c = io.nextInt();

        while (c-- > 0) {
            int n = io.nextInt(), m = io.nextInt(), best = Integer.MAX_VALUE;
            ArrayList<Person> arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                Person p = new Person(io.next(), io.nextInt());
                arr.add(p);
            }

            Collections.sort(arr,Comparator.comparing(Person::getName).thenComparing(Person::getPro));

            int total = 0;

            for (int i = 0; i < n; i ++) {
                while (i < m) { total += arr.get(i++).getPro(); }
                best = Math.min(best, total);
                if (i >= n) break;
                total += arr.get(i).getPro();
                total -= arr.get(i-m).getPro();
            }
            io.println(best);

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
class Person /* implements Corable*/ {
    private String name;
    private int pro;
    public Person(String name, int pro) {
        this.name =name;
        this.pro = pro;
    }

    public String getName() {return name;}
    public int getPro() {return pro;}
    public String toString() {return name + " " + pro;}
    /*
    public int compareTo(Object other) { 
        Person p = (Person)other;
        if (this.name.equals(p.getName())) {
            return (pro < p.getPro() ? -1 : (pro == p.getPro() ? 0 : 1));
        } else return (this.name.compareTo(p.getName()));
    }
    public boolean equals(Object other) { 
        Person p = (Person)other;
        return name.equals(p.getName()) && pro == p.getPro();
    }*/
}
