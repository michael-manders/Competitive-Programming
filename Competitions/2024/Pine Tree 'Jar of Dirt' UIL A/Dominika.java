import java.util.*;
import java.io.*;

class Dominika {
    public static void main(String [] args) throws IOException{
        Scanner in = new Scanner(new File ("dominika.dat"));

        int T = in.nextInt();

        while (T --> 0) {
            double ax = in.nextDouble();
            double ay = in.nextDouble();
            double bx = in.nextDouble();
            double by = in.nextDouble();
            
            double cx = (ax + bx) / 2 + (Math.sqrt(3) / 2) * (ay - by);
            double cy = (ay + by) / 2 - (Math.sqrt(3) / 2) * (ax - bx);
            
            cx = (double)Math.round(cx * 100) / 100.;
            cy = (double)Math.round(cy * 100) / 100.;

            System.out.println(cx + " " + cy);
            
            double aax = bx;
            double aay = by;
            double bbx = ax;
            double bby = ay;

             cx = (aax + bbx) / 2 + (Math.sqrt(3) / 2) * (aay - bby);
             cy = (aay + bby) / 2 - (Math.sqrt(3) / 2) * (aax - bbx);
            
            cx = (double)Math.round(cx * 100) / 100.;
            cy = (double)Math.round(cy * 100) / 100.;
            System.out.println(cx + " " + cy);


        }

    }
}