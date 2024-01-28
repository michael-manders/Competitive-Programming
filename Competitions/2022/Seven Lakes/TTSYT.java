import java.util.Arrays;
import java.lang.Math;

public class TTSYT {
	public static void main(String[] args) {
		for (int i = 0; i < 4; i++) {
			System.out.format("%d:\t%d\n", i, calc(i));
		}
	}

	private static int calc(int n) {
		if (n < 0) throw new IllegalArgumentException("n");
		if (n < 3) return n * n;

		// Find maximum bit count in nxn binary grid with no 3-in-a-row
		// Dynamic programming approach: given two rows, we can enumerate the possible third row.
		// sc[i + rows.length * j] is the greatest score achievable with a board ending in rows[i], rows[j].
		int[] rows = buildRows(n);
		byte[] sc = new byte[rows.length * rows.length];
		for (int j = 0, k = 0; j < rows.length; j++) {
			int qsc = Integer.bitCount(rows[j]);
			for (int i = 0; i < rows.length; i++) sc[k++] = (byte)(qsc + Integer.bitCount(rows[i]));
		}

		int max = 0;
		for (int h = 2; h < n; h++) {
			byte[] nsc = new byte[rows.length * rows.length];
			for (int i = 0; i < rows.length; i++) {
				int p = rows[i];
				for (int j = 0; j < rows.length; j++) {
					int q = rows[j];
					// The rows which follow p,q cannot intersect with a certain mask.
					int mask = (p & q) | ((p << 2) & (q << 1)) | ((p >> 2) & (q >> 1));
					for (int k = 0; k < rows.length; k++) {
						int r = rows[k];
						if ((r & mask) != 0) continue;
						int pqrsc = (sc[i + rows.length * j] & 0xff) + Integer.bitCount(r);
						int off = j + rows.length * k;
                        System.out.println();
                        for(int t = 0; t <Math.pow(pqrsc,2); t++) {
                            System.out.print("x");
                        }
						if (pqrsc > nsc[off]) nsc[off] = (byte)pqrsc;
						if (pqrsc > max) max = pqrsc;
					}
				}
			}

			sc = nsc;
		}

		return max;
	}

	private static int[] buildRows(int n) {
		// Array length is a tribonacci number.
		int c = 1;
		for (int a = 0, b = 1, i = 0; i < n; i++) c = a + (a = b) + (b = c);

		int[] rows = new int[c];
		int i = 0, j = 1, val;
		while ((val = rows[i]) < (1 << (n - 1))) {
			if (val > 0) rows[j++] = val * 2;
			if ((val & 3) != 3) rows[j++] = val * 2 + 1;
			i++;
		}

		return rows;
	}
}