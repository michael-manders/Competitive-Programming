/* 
ID: mjmande1
LANG: JAVA
TASK: crypt1
*/

import java.beans.DefaultPersistenceDelegate;
import java.io.*;
import java.util.*;

class crypt1 {
	public static void main (String[] args) throws IOException {
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
		BufferedReader br = new BufferedReader(new FileReader("crypt1.in"));
		
		int numberOfInputs = Integer.parseInt(br.readLine());
		List<Integer> validNums = new ArrayList<Integer>();
		for (String s: br.readLine().split(" ")) {validNums.add(Integer.parseInt(s));}
		
		int solutions = 0;

		List<Integer> didget3 = new ArrayList<Integer>();
		for (int d1: validNums) {
			for (int d2: validNums) {
                for (int d3: validNums) {
                    didget3.add(Integer.parseInt("" + d1 + d2 + d3));
                }
            }
		}
		List<Integer> didget2 = new ArrayList<Integer>();
		for (int d1: validNums) {
			for (int d2: validNums) {
                didget2.add(Integer.parseInt("" + d1 + d2));
            }
		}

		for (int did3: didget3) {
			for (int did2: didget2) {
                if (isValid(validNums, did3, did2)) {
				// System.out.println(did2 + " " + did3);
				solutions++;
				}
            }
		}

		// System.out.println(solutions);
		out.println(solutions);
		out.close();
		
	}

	public static boolean isValid(List<Integer> validNums, int didget3, int didget2) {
		int d1 = Integer.parseInt(("" + didget2).substring(0, 1));
		int d2 = Integer.parseInt(("" + didget2).substring(1));

		int p1 = d1 * didget3;
		int p2 = d2 * didget3;

		if ((("" + p1) + ("" + p2)).length() > 6) return false;

		for (String d: ("" + p1).split("")) {
			if (!validNums.contains(Integer.parseInt(d))) {
                return false;
            }
		}
		for (String d: ("" + p2).split("")) {
			if (!validNums.contains(Integer.parseInt(d))) {
                return false;
            }
		}

		for (String d: ("" + (didget2 *didget3)).split("")) {
			if (!validNums.contains(Integer.parseInt(d))) {
                return false;
            }
		} 

		// System.out.println("" + didget2 + " " + didget3 + " " + p1 + " " + p2 + " " + (didget2 * didget3));

		return true;
	}
}