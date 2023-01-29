import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Tabuls_12 {

    public static void main(String[] args) throws IOException {
        Kattio in = new Kattio("input");
        HashMap<String, HashMap<String, Integer>> orders = new HashMap<>();
        HashSet<String> names = new HashSet<>();
        HashSet<String> foods = new HashSet<>();
        while (true) {
            try {
                String[] ln = in.nextLine().split(" ");
                String name = ln[0].replace("_", "-").replace("-", " ");
                String food = title(ln[1].replace("_", "-").replace("-", " "));
                names.add(name);
                foods.add(food);
                if (orders.containsKey(name)) {
                    if (orders.get(name).containsKey(food)) {
                        orders.get(name).put(food, orders.get(name).get(food) + 1);
                    }
                    else {
                        orders.get(name).put(food, 1);
                    }
                }
                else {
                    HashMap<String, Integer> temp = new HashMap<>();
                    temp.put(food, 1);
                    orders.put(name, temp);
                }
            }
            catch (Exception e) {
                break;
            }
            
        }
        ArrayList<String> namesl = new ArrayList<>(names);
        ArrayList<String> foodsl = new ArrayList<>(foods);
        Collections.sort(namesl);
        Collections.sort(foodsl);
        for (String name: namesl) {
            System.out.print(name + " has ordered:");
            for (String food: foodsl) {
                if (orders.get(name).containsKey(food)) {
                    System.out.printf("\n\tx%d %s", orders.get(name).get(food), food);
                }
            }
            if (!name.equals(namesl.get(namesl.size() - 1))) {
                System.out.println("\n");
            }
            
        }
        
    }
    public static String title(String text) {
    if (text == null || text.isEmpty()) {
        return text;
    }

    StringBuilder converted = new StringBuilder();

    boolean convertNext = true;
    for (char ch : text.toCharArray()) {
        if (Character.isSpaceChar(ch)) {
            convertNext = true;
        } else if (convertNext) {
            ch = Character.toTitleCase(ch);
            convertNext = false;
        } else {
            ch = Character.toLowerCase(ch);
        }
        converted.append(ch);
    }

        return converted.toString();
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