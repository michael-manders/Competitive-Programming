import java.util.*;
import java.io.*;
import java.util.regex.*;

class jester {
    public static void main(String []args) {
        Kattio io = new Kattio();
        int n = io.nextInt();
        List<String> names = new ArrayList();
        while(n --  > 0) {
            String name = io.nextLine().replace(":","");
            String s = "";
            while(true) {
                String temp = io.nextLine();
                if(temp.equals("")) break;
                s += temp;
            }
            if(s.toLowerCase().indexOf("stroud") != -1 && !name.equalsIgnoreCase("jester")) names.add(name);
        }
        io.println("Fungeon List:");
        names.forEach(emp -> io.println(emp));
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
            } catch (Exception e) { return ""; }
        }

        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
        public String nextLine() {
            if (st != null && st.hasMoreTokens()) 
            { String out = ""; while (st.hasMoreTokens()) out += st.nextToken() + ' '; return out; }
            try { return r.readLine(); } catch (Exception e) { return ""; }
        }
    }
}