import java.util.*;
import java.io.*;

class Hiro {
    public static void main(String [] args) throws IOException{
        Scanner in = new Scanner(new File ("hiro.dat"));

        HashMap<String, Integer> numerals = new HashMap<String, Integer>();
        numerals.put("I", 1);
        numerals.put("IV", 4);
        numerals.put("V", 5);
        numerals.put("IX", 9);
        numerals.put("X", 10);
        numerals.put("XL", 40);
        numerals.put("L", 50);
        numerals.put("XC", 90);
        numerals.put("C", 100);
        numerals.put("CD", 400);
        numerals.put("D", 500);
        numerals.put("CM", 900);
        numerals.put("M", 1000);
        String[] order = {"CM", "CD", "XC", "XL", "IX", "M", "IV",  "D", "C", "L", "X", "V", "I"};

        int T = in.nextInt();
        in.nextLine();
        while (T --> 0) {

            String rn = in.nextLine();

            int total = 0;

            for (String r: order) {
                
                int o = 0;

                while (!rn.equals(rn.replace(r, ""))) {
                    int index = rn.indexOf(r);
                    rn = rn.substring(0, index) + rn.substring(index+r.length());
                    o++;
                }

                // System.out.println(r + " " +  o +  " " +  numerals.get(r));

                total += numerals.get(r) * o;

            }
            System.out.println(total);

        }

    }
    
}