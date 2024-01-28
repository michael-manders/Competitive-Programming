import java.util.*;
import java.lang.Math;
class earfquake
{
    public static void main(String[] args)
    {
        int x;
        int y;
        int m;
        double total = 0;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(;n>0;n--)
        {
            x = in.nextInt();
            y = in.nextInt();
            m = in.nextInt();
            double dist = Math.pow(x, 2) + Math.pow(y, 2);
            total += m * Math.pow(Math.E, -dist);
        }
        System.out.printf("%.3f\n", Math.abs(Math.log10(total)));
    }
}