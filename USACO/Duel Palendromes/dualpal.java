/* 
ID: mjmande1
LANG: JAVA
TASK: dualpal
*/

import java.io.*;
import java.util.*;


class dualpal {
	public static void main (String[] args) throws IOException {
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
		BufferedReader br = new BufferedReader(new FileReader("dualpal.in"));
		

		String[] input = br.readLine().split(" ");
		int number = Integer.parseInt(input[0]);
		int start = Integer.parseInt(input[1]); 


		List<Integer> bases = new ArrayList<Integer>(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10));
		List<Integer> nums = new ArrayList<>();

		int e = 0;
		for (int i = start + 1; e < number; i++) {
			int times = 0;
			for (int base: bases) {
				if (checkIfPalendrome(convertToBaseX(i, base))) {
					times++; 
				}
			}
			if (times >= 2) {
				nums.add(i);
				e++;
			}
		};

		for (int num: nums) out.println(num);
		out.close();
		
	}

	public static boolean checkIfPalendrome (String numString) {
		boolean palendrome = true;
		int j = numString.length();
		for (int i = 0; i < j; i++) {
			j--;
			if (numString.charAt(i)!= numString.charAt(j)) {
				palendrome = false;
				break;
			}
		}
		return palendrome;
	}

	public static String convertToBaseX(int number, int base) {
		return Integer.toString(
			Integer.parseInt("" + number, 10), base
		).toUpperCase();
	}
}