/* 
ID: mjmande1
LANG: JAVA
TASK: pprime
*/

import java.io.*;
import java.util.*;
import java.util.regex.*;

class pprime {
	public static void main (String[] args) throws IOException {
		
		Kattio io = new Kattio("pprime");

		int a = io.nextInt();
		int b = io.nextInt();
		List<Integer> primes = SieveOfAtkin(b);

		List<Integer> pals = generatePal(0, 0, 3, primes);

		HashSet<Integer> ps = new HashSet<Integer>();
        ps.addAll(pals);
        pals = new ArrayList<Integer>();
        pals.addAll(ps);
        pals.sort(Comparator.naturalOrder());
        for (int i = 0; i < pals.size(); i++) {
            if (pals.get(i)>=a && pals.get(i)<=b) {
                io.println(pals.get(i));
            }
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
            if (sieve[a])
                primes.add(a);
        return primes;
    }


	public static List<Integer> generatePal(int digits, int N, int max, List<Integer> primes) {
        List<Integer> pals = new ArrayList<Integer>();
        String temp1 = String.valueOf(digits);
        StringBuilder temp2 = new StringBuilder(temp1);
        temp1+=temp2.reverse();
        if (isPrime(Integer.parseInt(temp1), primes)) {
            pals.add(Integer.parseInt(temp1));
        }
        if (N>1) {
            int temp3 = digits/10;
            temp1 = String.valueOf(digits);
            temp2 = new StringBuilder(String.valueOf(temp3));
            temp1+=temp2.reverse();
            if (isPrime(Integer.parseInt(temp1), primes)) {
                pals.add(Integer.parseInt(temp1));
            }
        } else if (isPrime(digits, primes)) {
            pals.add(digits);
        }    
        if (N==0) {
            for (int d = 1; d <= 9; d+=2) {
                pals.addAll(generatePal(d, N+1, max, primes));
            }
        } else if (N<=max) {
            for (int d = 0; d <= 9; d++) {
                int temp = digits*10;
                temp+=d; 
                pals.addAll(generatePal(temp, N+1, max, primes));
            }
        }
        return pals;
    }

	// public static List<Integer> generatePalendromes() {
	// 	List<Integer> palendromes = new ArrayList<Integer>();

	// 	Pattern p = Pattern.compile("[1-9]");

	// 	for (int d1 = 0; d1 <= 9; d1+=1) {	/* only odd; evens aren't so prime */
	// 		if (d1 % 2 == 0 && d1 != 0) continue;
	// 		for (int d2 = 0; d2 <= 9; d2++) {
	// 			for (int d3 = 0; d3 <= 9; d3++) {
	// 				for (int d4 = 0; d4 <= 9; d4++) {
	// 					int palindrome = Integer.parseInt(""+d1+d2+d3+d4+d3+d2+d1);
	// 					if (palindrome == 0) continue;
	// 					while (palindrome % 10 == 0) {
	// 						palindrome = Integer.parseInt((""+palindrome).substring(0, (""+palindrome).lastIndexOf("0")));
	// 					}

	// 					palendromes.add(palindrome);	

	// 					palindrome = Integer.parseInt(""+d1+d2+d3+d4+d4+d3+d2+d1);

	// 					while (palindrome % 10 == 0) {
	// 						palindrome = Integer.parseInt((""+palindrome).substring(0, (""+palindrome).lastIndexOf("0")));
	// 					}

	// 					palendromes.add(palindrome);	
	// 				}
	// 			}	
	// 		}	
	// 	}
	// 	Collections.sort(palendromes);
	// 	// Collections.reverse(palendromes);

	// 	return palendromes;
	// }

	// static boolean isPrime(int n){
    //     boolean result=true;
    //     if(n <= 1) return false;
    //     for(int i = 2; i <= n/2; i++){ //n/2 because the largest factor of any number is either it's half or less than it
    //         if(n % i == 0){
    //             result = false; //if some number divides it, then prime=false;
    //             break;
    //         }
    //     }
    //     return result;
    // }

	public static boolean isPrime(int number, List<Integer> primes) {
        int sqrt = (int) Math.sqrt(number) + 1;
        for (int i = 0; i < primes.size(); i++) {
            if (number % primes.get(i) == 0 && primes.get(i)>1 && primes.get(i) < sqrt) {
                return false;
            }
        }
        return true;
    }
}




class Kattio extends PrintWriter {
    private BufferedReader r;
    private StringTokenizer st;
    // standard input
    public Kattio() { this(System.in,System.out); }
    public Kattio(InputStream i, OutputStream o) {
        super(o);
        r = new BufferedReader(new InputStreamReader(i));
    }
    // USACO-style file input
    public Kattio(String problemName) throws IOException {
        super(problemName+".out");
        r = new BufferedReader(new FileReader(problemName+".in"));
    }
    // returns null if no more input
    public String next() {
        try {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(r.readLine());
            return st.nextToken();
        } catch (Exception e) {}
        return null;
    }
    public int nextInt() { return Integer.parseInt(next()); }
    public double nextDouble() { return Double.parseDouble(next()); }
    public long nextLong() { return Long.parseLong(next()); }
}