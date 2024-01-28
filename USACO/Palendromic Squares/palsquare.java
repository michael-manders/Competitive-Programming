/* 
ID: mjmande1
LANG: JAVA
TASK: palsquare
*/

import java.io.*;
import java.util.*;

class palsquare {
	public static void main (String[] args) throws IOException {
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
		BufferedReader br = new BufferedReader(new FileReader("palsquare.in"));
		
		int base = Integer.parseInt(br.readLine());
		
		for (int i = 1; i < 300; i++) {
			String squared = convertToBaseX(i * i, base);
			if (checkIfPalendrome(squared)) {
				out.print(convertToBaseX(i, base) + " ");
				out.println(squared);
			}
		}
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