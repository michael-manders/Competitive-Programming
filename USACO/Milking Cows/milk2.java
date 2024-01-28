/* 
ID: mjmande1
LANG: JAVA
TASK: milk2
*/

import java.io.*;
import java.util.*;

class milk2 {
	public static void main (String[] args) throws IOException {
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
		BufferedReader br = new BufferedReader(new FileReader("milk2.in"));
		
		int number = Integer.parseInt(br.readLine());
		
		Integer[][] arr = new Integer[number][2];

		for (int i = 0; i < number; i++) {
			String numsString = br.readLine();
			String[] splits = numsString.split(" ");
			arr[i][0] = Integer.parseInt(splits[0]);
			arr[i][1] = Integer.parseInt(splits[1]);
		}

		int notMilking = 0;
		int milking = 0;
		int latest = findMaxValue(arr);
		int earliest = findMinValue(arr);
		boolean tracker = false;
		int notTemp = 0;
		int milkTemp = 0;
		
		for (int i = earliest; i < latest; i++) {
			boolean current = checkIfMilking(arr, i);
			// out.println(current +" " + i);
			if (i > 0) {
				boolean last = checkIfMilking(arr, i - 1);

				if (current != last) {
					if (!last) {
						if (notTemp > notMilking) notMilking = notTemp;
						notTemp = 0;
					}
					else {
						if (milkTemp > milking) milking = milkTemp;
						milkTemp = 0;
					}
				}
			}
			if (current) milkTemp++;
			else notTemp++;
		}
		if (milkTemp > milking) milking = milkTemp;
		if (notTemp > notMilking) notMilking = notTemp;

		// milking--;
		// notMilking++;

		out.println(milking + " " + notMilking);
		out.close();
		
	} 

	private static int findMaxValue(Integer[][] arr) {
		int max = 0;
		for (Integer[] i: arr) {
			if (i[1] > max) {
				max = i[1];
			}
		}
		return max;
	}

	private static int findMinValue(Integer[][] arr) {
		int min = 99999;
		for (Integer[] i: arr) {
			if (i[0] < min) {
				min = i[0];
			}
		}
		return min;
	}

	private static boolean checkIfMilking(Integer[][] arr, int time) {
		boolean milking = false;
		for (Integer[] i: arr) {
			if (time >= i[0] && time < i[1]) milking = true;
		}
		return milking;
	}
}