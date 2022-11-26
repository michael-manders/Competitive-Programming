/* 
ID: mjmande1
LANG: JAVA
TASK: skidesign
*/

import java.io.*;
import java.util.*;

class skidesign {
	public static void main (String[] args) throws IOException {
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
		BufferedReader br = new BufferedReader(new FileReader("skidesign.in"));
		
		int numberOfHills = Integer.parseInt(br.readLine());
		List<Integer> hills = new ArrayList<Integer>();

		for (int i = 0; i < numberOfHills; i++) {
            int hill = Integer.parseInt(br.readLine());
            hills.add(hill);
        }

		int units = 0;

		List<Integer> beforeHills = new ArrayList<Integer>(hills);

		int mincost = 999999999;

		for (int i = 0; i <= 83; i++) {
			int cost = 0;
			int x = 0;
			for (int j = 0; j < numberOfHills; j++) { 
				if (hills.get(j) < i) {
					x = i - hills.get(j);
				}
				else if (hills.get(j) > i + 17) {
					x = hills.get(j) - i - 17;
				}
				else x = 0;

				cost+= Math.pow(x, 2);
			}
			if (cost < mincost) mincost = cost;
		}

		out.println(mincost);
		out.close();

		
	}


}






// public static List<Integer> iterate (List<Integer> before) {
// 	List<Integer> after = new ArrayList<Integer>(before);
// 	int max = Collections.max(before);
// 	int min = Collections.min(before);
// 	if (Math.abs(max - min) > 17) {
// 		after.set(after.indexOf(max), max - 1);
// 		after.set(after.indexOf(min), min + 1);
// 	}
// 	return after;
// } 


// while (true) {
		// 	List<Integer> result = iterate(hills);
		// 	if (result.equals(hills)) break;
		// 	else {
		// 		// System.out.println(hills + " " + result + " " + units);
		// 		hills = result;
		// 	}
			
		// }

		// List<Integer> differences = new ArrayList<Integer>();

		// for (int i = 0; i < beforeHills.size(); i++) {
		// 	differences.add(Math.abs(beforeHills.get(i) - hills.get(i)));
		// }

		// for (int diff: differences) {
		// 	units += diff * diff;
		// }
		// System.out.println(beforeHills);
		// System.out.println(hills);
		// System.out.println(differences);

		// System.out.println(units);
		// out.println(units);
		// out.close();