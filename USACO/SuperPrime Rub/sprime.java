/* 
ID: mjmande1
LANG: JAVA
TASK: sprime
*/

import java.io.*;
import java.util.*;

class sprime {
	public static void main (String[] args) throws IOException {
		
		Kattio io = new Kattio("sprime");
		int n = io.nextInt();
		int pow = (int)Math.pow(10, n);

		ArrayList<Integer> primePrimes = new ArrayList<Integer>();

		List<Integer> primes = SieveOfAtkin(pow);
		for (int prime: primes) {
			if (prime < (int)Math.pow(10, n -1 )) continue;
			String p = ""+prime;
			boolean val = true;
			for (int i = 1; i < p.length(); i++) {
				// System.out.println(p.substring(0, i));
				if (!primes.contains(Integer.parseInt(p.substring(0, i)))) val = false;;
			}
			if (val)
			primePrimes.add(prime);
		}

		
		// System.out.println(primePrimes);
		for (int primePrime: primePrimes) {
			io.println(primePrime);
		}
		io.close();
	}

	static List<Integer> SieveOfAtkin(int limit)
    {
        List<Integer> primes = new ArrayList<>();
        if (limit > 2)
            primes.add(2);

        if (limit > 3)
            primes.add(3);
        boolean sieve[] = new boolean[limit+1];

        for (int i = 0; i <= limit; i++)
            sieve[i] = false;
        for (int x = 1; x * x <= limit; x++) {
            for (int y = 1; y * y <= limit; y++) {
                int n = (4 * x * x) + (y * y);
                if (n <= limit
                    && (n % 12 == 1 || n % 12 == 5))

                    sieve[n] ^= true;

                n = (3 * x * x) + (y * y);
                if (n <= limit && n % 12 == 7)
                    sieve[n] ^= true;

                n = (3 * x * x) - (y * y);
                if (x > y && n <= limit
                    && n % 12 == 11)
                    sieve[n] ^= true;
            }
        }
        for (int r = 5; r * r <= limit; r++) {
            if (sieve[r]) {
                for (int i = r * r; i <= limit;
                     i += r * r)
                    sieve[i] = false;
            }
        }
        for (int a = 5; a <= limit; a+=2)
            if (sieve[a]){
				if ( (""+a).contains("4") || (""+a).contains("6") || (""+a).contains("8") || (""+a).contains("0") ) continue;
                primes.add(a);	
			}
        return primes;
    }


}

class Kattio extends PrintWriter {
	private BufferedReader r;
	private StringTokenizer st;

	public Kattio() { this(System.in, System.out); }
	public Kattio(InputStream in, OutputStream out) { super(out); r = new BufferedReader(new InputStreamReader(in)); };
	public Kattio(String name) throws IOException { super(name + ".out"); r = new BufferedReader(new FileReader(name + ".in")); }
	public String next() {
		try {
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(r.readLine());
			return st.nextToken();
		} catch (Exception e) { return null; }
	}

	public int nextInt() { return Integer.parseInt(next()); }
	public double nextDouble() { return Double.parseDouble(next()); }
	public long nextLong() { return Long.parseLong(next()); }
	public String nextLine() {
		if (st != null && st.hasMoreTokens()) 
		{ String out = ""; while (st.hasMoreTokens()) out += st.nextToken() + ' '; return out; }
		try { return r.readLine(); } catch (Exception e) { return null; }
	}
}