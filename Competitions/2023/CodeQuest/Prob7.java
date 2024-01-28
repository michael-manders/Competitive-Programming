import java.util.Scanner;
import java.util.ArrayList;

class Prob7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        ArrayList<Integer> total = new ArrayList<>();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();

            for (int i = 0; i < n; i++) {
                String dif = scanner.next();
                int num = scanner.nextInt();

                if (dif.equals("HIGH")) {
                    total.add(num);
                    total.add(num);
                    total.add(num);
                } else if (dif.equals("MEDIUM")) {
                    total.add(num);
                    total.add(num);
                } else {
                    total.add(num);
                }
            }

            int average = (int)Math.round((double)sum(total)/total.size()*10);
            System.out.println(average);

            total.clear();
        }
    }

    private static int sum(ArrayList<Integer> list) {
        int sum = 0;

        for (int i : list) {
            sum += i;
        }

        return sum;
    }
}
