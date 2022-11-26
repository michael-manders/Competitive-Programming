/* 
ID: mjmande1
LANG: JAVA
TASK: barn1
*/

import java.io.*;
import java.util.*;

class barn1 {
	public static void main (String[] args) throws IOException {
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
		BufferedReader br = new BufferedReader(new FileReader("barn1.in"));
		
		String[] input = br.readLine().split(" ");
		int maximum = Integer.parseInt(input[0]);
		int stalls = Integer.parseInt(input[1]);
		int occupiedNumber = Integer.parseInt(input[2]);

		List<Integer> occupied = new ArrayList<Integer>();
		for (int i = 0; i < occupiedNumber; i++) {
			int x = Integer.parseInt(br.readLine());
            occupied.add(x);
		};

		if (maximum >= occupiedNumber) {
			out.println(occupiedNumber);
			out.close();
			br.close();
            return;
		}

		Collections.sort(occupied);

		List<Integer> differences = new ArrayList<>();
		
		for (int i = 0; i < occupied.size() -1; i++) {
			int x = occupied.get(i);
            int y = occupied.get(i + 1);
            int diff = y - x - 1;
			differences.add(diff);
		}

		List<Integer> differencesOrdered = new ArrayList<>(differences);
		Collections.sort(differences);
		Collections.reverse(differences);

		List<Integer> splits = new ArrayList<>();

		for (int i = 0; i < maximum - 1; i++) {
			int diff = differences.get(i);
			int index = differencesOrdered.lastIndexOf(diff);
			splits.add(index);
		}
		splits.add(-1);
		splits.add(occupied.size());
		Collections.sort(splits);

		// System.out.println(occupied);
		// System.out.println(splits);
		
		int covered = 0;

		for (int i = 0; i < splits.size() -1; i++) {
			int x = splits.get(i) + 1;
			int y = splits.get(i + 1);
			try {
				// System.out.println(occupied.get(x) + " " + occupied.get(y) + " " + (occupied.get(y) - occupied.get(x)));
				covered+=occupied.get(y) - occupied.get(x) + 1;
			}	
			catch (Exception e) {
				// System.out.println(occupied.get(x) + " " + occupied.get(y - 1) + " " + (occupied.get(y- 1) - occupied.get(x)));
				covered+= occupied.get(y - 1) - occupied.get(x) + 1;
			};			
		}

		out.println(covered);
		br.close();
        out.close();	
	}
}