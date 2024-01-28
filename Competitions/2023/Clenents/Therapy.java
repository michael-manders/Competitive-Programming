import java.util.*;
import java.io.*;

class Therapy {
    public static void main(String [] args) throws IOException{
        Scanner in = new Scanner(new File ("Therapy.in"));

        int N = in.nextInt();
        int M = in.nextInt();
        int NN = N + 0;

        ArrayList<Integer> a = new ArrayList<>();
        while (N-->0) a.add(in.nextInt());
        Collections.sort(a);

        Collections.reverse(a);

        ArrayList<Integer> d = new ArrayList<>();

        while (!a.isEmpty()) {
            int t = 0;
            ArrayList<Integer> aa = new ArrayList<>(a);
            for (int i = 0; i < NN; i++) {
                for (int v: a) {
                    if (t + v < M) {
                        t += v;
                        if (aa.indexOf(v) > -1){
                            aa.remove(aa.indexOf(v));
                        }
                    }
                }
            }
            d.add(t);
            a = aa;
        }

        Collections.sort(d);
        Collections.reverse(d);
        String out = "";
        for (int dd: d) {
            out+= dd + " ";
        }
        System.out.println(out.strip());
    }
}