/* 
ID: mjmande1
LANG: JAVA
TASK: milk
*/

import java.io.*;
import java.util.*;

import javax.sound.midi.Soundbank;

class milk {
	public static void main (String[] args) throws IOException {
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
		BufferedReader br = new BufferedReader(new FileReader("milk.in"));
		
		String firstLine = br.readLine();
		int neededUnits = Integer.parseInt(firstLine.split(" ")[0]);
		int farmers = Integer.parseInt(firstLine.split(" ")[1]);
		HashMap<Integer, Integer> market = new HashMap<>();
		List<Integer> costs = new ArrayList<>();

		for (int i = 0; i < farmers; i++) {
			String line = br.readLine();
			int cost = Integer.parseInt(line.split(" ")[0]);
			int units = Integer.parseInt(line.split(" ")[1]);
			if (market.containsKey(cost)) {
				market.replace(cost, market.get(cost) + units);
			}
			else {
				costs.add(cost);
				market.put(cost, units);
			}
			
		}

		Collections.sort(costs);
		int totalUnits = 0;
		int totalCost = 0;
		int cost = 0;
		while (totalUnits < neededUnits) {
			cost = 0;
			for (int potentialCost: costs) {
				if (market.get(potentialCost) > 0) {cost = potentialCost; break;};
			}

			totalCost += cost * market.get(cost);
			totalUnits += market.get(cost);
			market.replace(cost, 0);
		}
		

		while (totalUnits > neededUnits) {
			
			totalCost -= cost;
			totalUnits--;
		}

		out.println(totalCost);
		br.close();
        out.close();
	}
}
