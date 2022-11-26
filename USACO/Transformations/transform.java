/* 
ID: mjmande1
LANG: JAVA
TASK: transform
*/

import java.io.*;
import java.util.*;

class transform {
	public static void main (String[] args) throws IOException {
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
		BufferedReader br = new BufferedReader(new FileReader("transform.in"));
		
		int number = Integer.parseInt(br.readLine());
		String[][] be = new String[number][number];
		String[][] after = new String[number][number];
		
		
		for (int i = 0; i < number; i++) {
			String[] arr = br.readLine().split("");
			for (int j = 0; j < number; j++) {
				be[i][j] = arr[j];
			}
		}
		for (int i = 0; i < number; i++) {
			String[] arr = br.readLine().split("");
			for (int j = 0; j < number; j++) {
				after[i][j] = arr[j];
			}
		}

		String[][] before = deepCopyIntMatrix(be);
		
		int output = 7;

		// now do the checks
		if (compare(rotate90(deepCopyIntMatrix(be)), after)) output = 1;
		else if (compare(rotate90(rotate90(deepCopyIntMatrix(be))), after)) output = 2;
		else if (compare(rotate90(rotate90(rotate90(deepCopyIntMatrix(be)))), after)) output = 3;
		else if (compare(mirrorX(deepCopyIntMatrix(be)), after)) output = 4;
		else if (checkCombination(deepCopyIntMatrix(be), after)) output = 5;
		else if (compare(deepCopyIntMatrix(be), after)) output = 6;


		out.println(output);
		out.close();
		
	}

	public static String[][] mirrorX (String[][] arr) {
		String[][] reversed = new String[arr.length][arr.length];
		int i = 0;
		for (String[] e: arr) {
			reversed[i] = reverseArray(e);
			i++;
		}

		return reversed;
	}

	public static String[] reverseArray(String[] arr) {
        String[] reversed = new String[arr.length];
		int i = reversed.length;
		for (String e: arr)  {
			i--;
			reversed[i] = e;
		}
		return reversed;
   }

    public static String[][] mirrorY (String[][] arr) {
		String[][] reversed = new String[arr.length][arr.length];
		int i = arr.length;
		for (int e = 0; e < arr.length; e++) {
			i--;
			reversed[i] = arr[e];
		}
		return reversed;
    }

	public static String[][] rotate90 (String[][] before) {
		int n = before.length;
		String[][] arr = before;
		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j< n-i-1; j++) {
				String temp = arr[i][j];
				arr[i][j] = arr[n - 1 - j][i];
				arr[n - 1 - j][i] = arr[n - 1 - i][n - 1 - j];
				arr[n - 1 - i][n - 1 - j] = arr[j][n - 1 - i];
				arr[j][n - 1 - i] = temp;
			}
		}
		
		return arr;
	}

	public static boolean checkCombination(String[][] before, String[][] after) {
		String[][] before1 = mirrorX(before);
		if (compare(rotate90(before1), after)) return true;
		else if (compare(rotate90(rotate90(before1)), after)) return true;
		else if (compare(rotate90(rotate90(rotate90(before1))), after)) return true;
		else if (compare(mirrorX(before1), after)) return true;
		else return false;
	}

	public static boolean compare(String[][] arr1, String[][] arr2) {

		// System.out.println(Arrays.deepToString(arr1));
		// System.out.println(Arrays.deepToString(arr2));
		if (Arrays.deepToString(arr1).equals(Arrays.deepToString(arr2)) ) return true;
		else return false;
	}

	public static String[][] deepCopyIntMatrix(String[][] input) {
		String[][] result = new String[input.length][input.length];
		int i = 0;
		for (String[] e: input) {
			result[i] = Arrays.copyOf(e, e.length);
			i++;
		}
		return result;
	}
}