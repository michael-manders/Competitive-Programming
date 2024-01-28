import java.util.*;
import java.io.*;

class SamuelsChicken {
    public static void main(String [] args) throws IOException{
        Scanner in = new Scanner(new File ("SamuelsChicken.in"));

        int t = 0;

        int N = in.nextInt();

        Character[] parts = {'L', 'W', 'H', 'F'};

        HashMap<Character, Integer> mm = new HashMap<>();
        for (Character c: parts) {
            mm.put(c, 0);
        }

        in.nextLine();
        while (N --> 0) {
            String[] v = in.nextLine().split(" ");
            HashMap<Character, Integer> m = new HashMap<>();
            for (Character c: parts) {
                m.put(c, 0);
            }

            for (String r: v) {
                // System.out.println(r);
                char c = r.charAt(r.length() - 1);
                int a = Integer.parseInt(r.substring(0, r.length() - 1));
                m.put(c, m.get(c) + a);
                mm.put(c, mm.get(c) + a);
            }

            m.put('L', (int)Math.ceil(1. * m.get('L') / 2));
            m.put('W', (int)Math.ceil(1. * m.get('W') / 2));
            m.put('F', (int)Math.ceil(1. * m.get('F') / 2));

            int max = -1;

            for (char p: parts) {
                if (m.get(p) > max) {max = m.get(p);}
            }

            System.out.println(max + " " + "Chicken" + (max == 1 ? "" : "s"));
        

        }

        mm.put('L', (int)Math.ceil(1. * mm.get('L') / 2));
        mm.put('W', (int)Math.ceil(1. * mm.get('W') / 2));
        mm.put('F', (int)Math.ceil(1. * mm.get('F') / 2));

        int max = -1;

        for (char p: parts) {
            if (mm.get(p) > max) {max = mm.get(p);}
        }

        System.out.println("Total number of chickens: " + max);

    }
}