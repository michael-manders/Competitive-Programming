
	public static List<Integer> sieveOfEratosthenes(int n) {
        List<Integer> primeNumbers = new LinkedList<>();
        boolean prime[] = new boolean[n + 1];
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * 2; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
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

	private static boolean isPalindrome(int x) {
        if(x < 0)
            return false;

        return x == reverseNum(x);

    }
    private static int reverseNum(int num){
        int rev = 0;
        while(num>0){
            int digit = num%10;
            rev = (rev * 10) + digit;
            num = num/10;
        }
        return rev;
    }

	static int createPalindrome(int input, int b, int isOdd) {
		int n = input;
		int palin = input;
	 
		// checks if number of digits is odd or even
		// if odd then neglect the last digit of input in
		// finding reverse as in case of odd number of
		// digits middle element occur once
		if (isOdd == 1)
			n /= b;
	 
		// Creates palindrome by just appending reverse
		// of number to itself
		while (n > 0) {
			palin = palin * b + (n % b);
			n /= b;
		}
		return palin;
	}
	 
	// Function to print decimal
	// palindromic number
	static List<Integer> generatePalindromes(int n) {
		int number;
	 
		// Run two times for odd and even
		// length palindromes
		List<Integer> pals = new ArrayList<Integer>();
		for (int j = 0; j < 2; j++) {
	 
		// Creates palindrome numbers with first
		// half as i. Value of j decided whether
		// we need an odd length of even length
		// palindrome.
			int i = 1;
			while ((number = createPalindrome(i, 10, j % 2)) < n) {
				pals.add(number);
				
				i++;
		}
		}
		return pals;
	}