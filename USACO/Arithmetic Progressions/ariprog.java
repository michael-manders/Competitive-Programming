/* 
ID: mjmande1
LANG: JAVA
TASK: ariprog
*/

import java.io.*;
import java.util.*;

class ariprog {
	public static void main (String[] args) throws IOException {
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
		BufferedReader br = new BufferedReader(new FileReader("ariprog.in"));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int max = m*m*2;
		boolean[] bisquares = new boolean[max + 1];
		ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();

		for (int p = 0; p <= m; p++) {
			for (int q = 0; q <= m; q++) {
				bisquares[p * p + q*q] = true;
			}
		}

		for (int i = 0; i < max; i++) {
			if (!bisquares[i]) {
				continue;
			}
			else {
				l: for (int j = 1; j <= (max-i) / (n - 1); j++) {
					for (int k = 1; k <= n - 1; k++) {
						if (!bisquares[i + j * k])
							continue l;
					}
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(j);
					temp.add(i);
					r.add(temp);
				}
			}
		}

		r = sortArray(r);
        if (r.size() > 0) {
            for (ArrayList<Integer> result : r) {
                out.println(result.get(1) + " " + result.get(0));
            }
        } else {
            out.println("NONE");
        }
        out.close();

        br.close();

	}

	public static ArrayList<ArrayList<Integer>> sortArray(ArrayList<ArrayList<Integer>> results) {
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            if (results.size()>1) {
                for (int i = 1; i < results.size(); i++) {
                    if (results.get(i - 1).get(0) > results.get(i).get(0)) {
                        Collections.swap(results, i - 1, i);
                        swapped = true;
                    } else if (results.get(i - 1).get(0) == results.get(i).get(0) && results.get(i - 1).get(1) > results.get(i).get(1)) {
                        Collections.swap(results, i - 1, i);
                        swapped = true;
                    }
                }
            }
        }
        return results;
    }
}

