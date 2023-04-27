import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner inp;
    private static PrintWriter out;

    public static void main(String[] args) throws IOException {
        inp = new Scanner(new File("input.txt"));
        out = new PrintWriter(new File("output.txt"));

        int T = inp.nextInt();
        for (int t = 0; t < T; t++) {
            int N = inp.nextInt();
            int C = inp.nextInt();
            int Q = inp.nextInt();
            int[][] grid = new int[N][N];
            List<String> colors = new ArrayList<>();

            for (int q = 0; q < Q; q++) {
                int x = inp.nextInt();
                int y = inp.nextInt();
                String color = inp.next().trim();
                if (!colors.contains(color)) {
                    colors.add(color);
                }
                int colorIndex = colors.indexOf(color) + 1;
                grid[x][y] = colorIndex;
            }

            int size = colors.size();
            boolean done = false;
            while (!done) {
                List<Pair<Integer, Integer>> dimensions = getPossibleWindowDimensions(size);

                for (Pair<Integer, Integer> dimension : dimensions) {
                    int w = dimension.getKey();
                    int h = dimension.getValue();

                    for (int x = 0; x <= N - w; x++) {
                        for (int y = 0; y <= N - h; y++) {
                            int x2 = x + w - 1;
                            int y2 = y + h - 1;

                            if (checkIfSubarrContainsAll(grid.clone(), colors, x, y, x2, y2)) {
                                int subArrSize = w * h;
                                String output = String.format("Case #%d: %d %d %d %d %d", t + 1, x, y, x2, y2,
                                        subArrSize);
                                System.out.println(output);
                                out.println(output);
                                done = true;
                                break;
                            }
                        }
                        if (done) {
                            break;
                        }
                    }
                    if (done) {
                        break;
                    }
                }

                if (done) {
                    break;
                }

                size++;
            }
        }

        inp.close();
        out.close();
    }

    private static boolean checkIfSubarrContainsAll(int[][] grid, List<String> colors, int x, int y, int x2, int y2) {
        for (String color : colors) {
            int colorIndex = colors.indexOf(color) + 1;
            List<Integer> subArr = new ArrayList<>();

            for (int i = x; i <= x2; i++) {
                for (int j = y; j <= y2; j++) {
                    int index = grid[i][j];

                    if (!subArr.contains(index)) {
                        subArr.add(index);
                    }
                }
            }

            if (!subArr.contains(colorIndex)) {
                return false;
            }
        }

        return true;
    }

    private static List<Pair<Integer, Integer>> getPossibleWindowDimensions(int size) {
        List<Pair<Integer, Integer>> dimensions = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            if (size % i == 0) {
                dimensions.add(new Pair<>(i, size / i));
            }
        }
        return dimensions;
    }
}

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
