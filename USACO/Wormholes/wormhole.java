/* 
ID: mjmande1
LANG: JAVA
TASK: wormhole
*/

import java.io.*;
import java.util.*;

class wormhole {
	public static void main (String[] args) throws IOException {
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
		BufferedReader br = new BufferedReader(new FileReader("wormhole.in"));
		int n = Integer.parseInt(br.readLine());
        long[] x = new long[n+1];
        long[] y = new long[n+1];
        int[] partner = new int[n+1];
        int[] next = new int[n+1];
        
        for (int i = 1; i <= n; i++) {
            StringTokenizer line = new StringTokenizer(br.readLine());
            x[i] = Long.parseLong(line.nextToken());
            y[i] = Long.parseLong(line.nextToken());
        }

		for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(x[i]<x[j] && y[i]==y[j]) {
                    if(next[i]==0 || x[j]-x[i]<x[next[i]]-x[i]) {
                        next[i]=j;
                    }
                }
            }
        }

		out.println(solve(next, partner, n));
		out.close();
		
	}

	public static int solve(int[] next, int[] partner, int n) {
        int total = 0;
		int i = 0;
        for (i = 1; i <= n; i++) {
            if(partner[i] == 0) {
                break;
            }
        }
        if (i > n) {
            if(cycleExists(next, partner, n)) {
                return 1;
            } else {
                return 0;
            }
        }
        for (int j=i+1; j<=n; j++) {
            if (partner[j] == 0) {
                partner[i] = j;
                partner[j] = i;
                total += solve(next, partner, n);
                partner[i] = 0;
                partner[j] = 0;
            }
        }
        return total;
    }

	public static boolean cycleExists(int[] next, int[] partner, int n) {
        for (int start = 1; start <= n; start++) {
            int pos = start;
            for (int count = 0; count < n; count++) {
                pos=next[partner[pos]];
            }
            if(pos!=0) {
                return true;
            }
        }
        return false;
    }
}