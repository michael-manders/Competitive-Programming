import java.io.*;
import java.util.*;

public class prefix {

    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new FileReader("prefix.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("prefix.out")));

        List<String> prefixes = new ArrayList<>();
        StringBuilder seqBuilder = new StringBuilder();
        boolean seqStart = false;
        String line;

        while ((line = inp.readLine()) != null) {
            line = line.trim();
            if (line.equals(".")) {
                seqStart = true;
                continue;
            }
            if (!seqStart) {
                Collections.addAll(prefixes, line.split("\s+"));
            } else {
                seqBuilder.append(line);
            }
        }
        String seq = seqBuilder.toString();

        Map<Integer, List<String>> dp = new HashMap<>();
        // sort prefixes by length
        Collections.sort(prefixes, (a, b) -> Integer.compare(b.length(), a.length()));

        int skips = 0;

        for (int i = 0; i < seq.length(); i++) {
            if (skips > 0) {
                skips--;
                continue;
            }

            for (String prefix : prefixes) {
                // if the prefix matches that spot in the sequence add it to the dp list
                if (seq.substring(i).startsWith(prefix)) {
                    if (dp.get(i) == null) 
                        dp.put(i, new ArrayList<>());
                    dp.get(i).add(prefix);
                    skips += prefix.length() - 1; // skip ahead length - 1
                    break;
                }
            }
        }

        boolean[] possible = new boolean[seq.length()];
        for (int i = 0; i < seq.length(); i++) {
            List<String> d = dp.get(i);
            int maxLenInD = d != null ? d.stream().mapToInt(String::length).max().orElse(0) : 0;
            if (maxLenInD == 0) continue;
            else {
                for (int j = i; j < i + maxLenInD; j++) 
                    possible[j] = true;
            }
        }

        // find the first false
        int index = seq.length();
        for (int i = 0; i < seq.length(); i++) 
            if (!possible[i]) {
                index = i;
                break;
            }

        System.out.println(index);
        out.println(index);

        inp.close();
        out.close();
    }
}
