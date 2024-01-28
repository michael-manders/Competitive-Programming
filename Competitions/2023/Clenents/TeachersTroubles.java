import java.util.*;
import java.io.*;

class TeachersTroubles {
    public static void main(String [] args) throws IOException{
        Scanner in = new Scanner(new File ("TeachersTroubles.in"));

        int N = in.nextInt();
        int M = in.nextInt();

        HashMap<String, String> map = new HashMap<>();

        in.nextLine();
        while (N-->0) {
            String[] a = in.nextLine().split(" ");
            map.put(a[1], a[0]);
        }
        while (M-->0) {
            System.out.println(map.get(in.nextLine()));
        }

    }
}