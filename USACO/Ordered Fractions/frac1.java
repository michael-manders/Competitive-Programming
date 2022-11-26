/* 
ID: mjmande1
LANG: JAVA
TASK: frac1
*/

import java.io.*;
import java.util.*;

class frac1 {
	public static void main (String[] args) throws IOException {
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));
		BufferedReader br = new BufferedReader(new FileReader("frac1.in"));
		
		int i = Integer.parseInt(br.readLine());

		HashMap<Float, String> map = new HashMap<Float, String>();
		ArrayList<Float> list = new ArrayList<Float>();

		for (int d = 1; d <= i; d++) {
			for (int n = 0; n <= i; n++) {
				if (n > d) continue;
				Float value = (float)n / d;
				if (map.containsKey(value)) continue;
				String s = n + "/" + d;
				map.put(value, s);
				list.add(value);
			}
		}
		Collections.sort(list);
		for (float v: list) {
			out.println(map.get(v));
		}

		out.close();

	}
}