/* 
ID: mjmande1
LANG: JAVA
TASK: lamps
*/

import java.util.*;
import java.io.*;

public class lamps {
    public static void main(String []args) throws IOException {
        Kattio io = new Kattio("lamps");
        
        int N = io.nextInt();
        int C = io.nextInt();

        List<Integer> ons = new ArrayList<Integer>();
        List<Integer> offs = new ArrayList<Integer>();

        while (true) {
            int i = io.nextInt();
            if (i == -1) break;
            else {
                ons.add(i);
            }
        }
        while (true) {
            int i = io.nextInt();
            if (i == -1) break;
            else {
                offs.add(i);
            }
        }

        String[] pos = {"111111", "000000", "010101", "101010", "011011", "100100", "110001", "001110"};
        ArrayList<String> solutions = new ArrayList<String>();

         if (C % 6 == 0) {
            solutions.add(pos[0]);
            if (C > 0) {
                solutions.add(pos[1]);
                solutions.add(pos[2]);
                solutions.add(pos[3]);
                solutions.add(pos[4]);
                solutions.add(pos[5]);
                solutions.add(pos[6]);
                solutions.add(pos[7]);
            }
        } else if (C % 6 == 1) {
            solutions.add(pos[1]);
            solutions.add(pos[2]);
            solutions.add(pos[3]);
            solutions.add(pos[4]);
        } else if (C % 6 == 2) {
            solutions.add(pos[0]);
            solutions.add(pos[1]);
            solutions.add(pos[2]);
            solutions.add(pos[3]);
            solutions.add(pos[5]);
            solutions.add(pos[6]);
            solutions.add(pos[7]);
        } else if (C % 6 == 5) {
            solutions.add(pos[0]);
            solutions.add(pos[4]);
            solutions.add(pos[5]);
            solutions.add(pos[6]);
            solutions.add(pos[7]);
        } else {
            solutions.addAll(Arrays.asList(pos));
        }

        ArrayList<String> verified = new ArrayList<String>();

        for (String solution: solutions) {
            boolean works = true;
            for (int o: ons) {
                o = o % 6 - 1;
                if (o == -1) o = 0;
                if (solution.charAt(o) != '1') works = false;
            }
            for (int f: offs) {
                f = f % 6 - 1;
                if (f == -1) f = 0;
                if (solution.charAt(f) != '0') works = false;
            }
            if (works) verified.add(solution);
        }

        HashMap<Integer, String> results = new HashMap<Integer, String>();
        ArrayList<Integer> r = new ArrayList<Integer>();

        for (String solution: verified) {
            String s = new String(solution);
            while (s.length() < N) {
                s = s + solution;
            }
            s = s.substring(0, N);
            results.put(Integer.parseInt(s.substring(0, 6), 2), s);
            r.add(Integer.parseInt(s.substring(0, 6), 2));
        }  

        if (verified.size() == 0){
            System.out.println("IMPOSSIBLE");
            io.println("IMPOSSIBLE");      
        }
        else {
            Collections.sort(r);
            for (int i: r) {
                System.out.println(results.get(i));
                io.println(results.get(i));
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
