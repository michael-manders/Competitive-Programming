/* 
ID: mjmande1
LANG: JAVA
TASK: combo
*/

import java.io.*;
import java.util.*;

class combo {
	public static void main (String[] args) throws IOException {
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
		BufferedReader br = new BufferedReader(new FileReader("combo.in"));
		
		int positions = Integer.parseInt(br.readLine());
		String combo1str = br.readLine();
		String combo2str = br.readLine();
		
		List<Integer> combo1 = new ArrayList<Integer>();
		List<Integer> combo2 = new ArrayList<Integer>();
		
		for (String d: combo1str.split(" "))   combo1.add(Integer.parseInt(d));
		for (String d: combo2str.split(" "))   combo2.add(Integer.parseInt(d));

		List<String> combos = new ArrayList<String>();

		for (int d1: generatePlay(combo1.get(0), positions)) {
			for (int d2: generatePlay(combo1.get(1), positions)) {
				for (int d3: generatePlay(combo1.get(2), positions)) {
					combos.add((d1+" "+d2+" "+d3));
				}
			}
		}

		for (int d1: generatePlay(combo2.get(0), positions)) {
			for (int d2: generatePlay(combo2.get(1), positions)) {
				for (int d3: generatePlay(combo2.get(2), positions)) {
					combos.add(d1+" "+d2+" "+d3);
				}
			}
		}

		

		Set<String> combos1 = new LinkedHashSet<String>(combos);
		combos.clear();
		combos.addAll(combos1);

		// System.out.println(combos + " " + combos.size());
		out.println(combos.size());
		out.close();
	}

	public static int con(int positions, int pos) {
		if (positions <= 3) {
			if (pos > positions) {
			
				return con(positions, pos - positions);
			}
			if (pos <= 0) {
				return con(positions, positions - pos);
			}
			else {
				return pos;
			}
		}
		else {
			if (pos > positions) {
				// System.out.println(pos + " " + (pos - positions)) ;
				return pos - positions;
			}
			if (pos <= 0) {
				// System.out.println(pos + " " + (positions - Math.abs(pos)));
				return positions - Math.abs(pos);
			}
			else {
				return pos;
			}
		}
		
	}

	public static List<Integer> generatePlay(int n, int positions) {
		List<Integer> plays = new ArrayList<Integer>();
        
		for (int i = -2; i <= 2; i++) {
			plays.add(con(positions, n + i));
		}
		return plays;
	}

}

