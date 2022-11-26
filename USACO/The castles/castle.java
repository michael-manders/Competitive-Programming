/* 
ID: mjmande1
LANG: JAVA
TASK: castle
*/

import java.io.*;
import java.util.*;

class castle {
	public static void main (String[] args) throws IOException {
		Kattio io = new Kattio("castle");

		int x = io.nextInt();
		int y = io.nextInt();

		boolean[][][] castle = new boolean[y][x][4];

		for (int y1 = 0; y1 < y; y1++) {
			for (int x1 = 0; x1 < x; x1++) {
				String binary = Integer.toBinaryString(io.nextInt());
				while (binary.length() < 4) {
					binary = "0" + binary;
				}
				for (int i = 0; i < 4; i++) {
					castle[y1][x1][i] = binary.charAt(i) == '0';
				}
			}
		}

		int max = 0;
		int[] p = new int[3]; 
		ArrayList<Integer> skip = new ArrayList<>();
		String[] directions = {"S", "E", "N", "W"};

		for (int i = 0; i < x * y; i++) {
			System.out.println(i);
			for (int e = 0; e < 4; e++) {
				ArrayList<Integer> a = sizeRoom(removeWall(castle, i, e), i, x, y);
				int r = a.size();
				if (r> max) {
					int[] lc = location(i,x, y);
					max = r;
					// s = String.format("%d %d %s", lc[0], lc[1], directions[e]);
					p[0] = lc[0];
					p[1] = lc[1];
					p[2] = e;
				}
				else if (r == max) {
					int[] lc = location(i,x, y);
					if (p[0] > lc[0]) {
						p[0] = lc[0];
						p[1] = lc[1];
						p[2] = e;
					}
					else if (p[0] == lc[0]) {
						if (p[1] < lc[1]) {
							p[0] = lc[0];
							p[1] = lc[1];
							p[2] = e;
						}
						else if (p[1] == lc[1]) {
							if (e == 2) {
								p[0] = lc[0];
								p[1] = lc[1];
								p[2] = e;
							}
						}
					}
				}
			}
		}
		int[] r = numberOfRooms(castle, x, y);
		String s = String.format("%d %d %s",p[1] + 1, p[0] + 1, directions[p[2]]);
		System.out.println(r[0]);
		System.out.println(r[1]);
		System.out.println(max);
		System.out.println(s);

		io.println(r[0]);
		io.println(r[1]);
		io.println(max);
		io.println(s);
		io.close();
	}

	public static int[] numberOfRooms(boolean[][][] castle, int x, int y) {

		ArrayList<Integer> rooms = new ArrayList<Integer>();
		for (int i = 0; i < x * y; i++) {
			rooms.add(i);
		}

		int roomNumbers = 0;
		int maxRoom = 0;
		ArrayList<Integer> skips = new ArrayList<Integer>();

		for (int r: rooms) {
			if (skips.contains(r)) continue;
			ArrayList<Integer> room = sizeRoom(castle, r, x, y);
			if (room.size() > maxRoom) maxRoom = room.size();
			roomNumbers++;
			skips.addAll(room);
		}

		int[] result = {roomNumbers, maxRoom};

		return result;
	}
	
	public static ArrayList<Integer> getNeighbors (boolean[][][] castle, int room, int x, int y) {
		int[] moves = {
			+x, 
		+1,     -x,
			-1
		};

		int[] lc = location(room, x, y);
		ArrayList<Integer> neighbors = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			if (castle[lc[1]][lc[0]][i]) {
				neighbors.add(room + moves[i]);
			}
		}
		return neighbors;
	}

	public static int[] location(int i, int x, int y) {
		int[] result = new int[2];
		result[0] = (i%(x));
		result[1] = (i - result[0]) / x;
		return result;
	}

	public static int index(int[] lc, int x, int y) {
		return lc[y] * x + lc[x];
	}

	public static ArrayList<Integer> sizeRoom (boolean[][][] castle, int rn, int x, int y) {
		ArrayList<Integer> room = new ArrayList<Integer>();
		room.add(rn);
		for (int r: getNeighbors(castle, rn, x, y)) room.add(r);
		Collections.sort(room);

		while (true) {
			ArrayList<Integer> newRooms = new ArrayList<Integer>();
			for (int r: room) {
				newRooms.addAll(getNeighbors(castle, r, x, y));
				newRooms.add(r);
			}
			newRooms = removeDuplicates(newRooms);
			Collections.sort(newRooms);
			// System.out.println(newRooms);
			if (room.equals(newRooms)) break;
			else room = newRooms;
		}

		return room;
	} 

	public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) {
        ArrayList<T> newList = new ArrayList<T>();
        for (T element : list) {
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }
        return newList;
    }

	private static boolean[][][] copyOf3Dim(boolean[][][] array) {
		boolean[][][] copy = new boolean[array.length][array[0].length][4];
		for (int x = 0; x < array.length; x++) {  
			for (int y = 0; y < array[0].length; y++) {  
				for (int z = 0; z < array[0][0].length; z++) {
					copy[x][y][z] = array[x][y][z];  
				}  
			}  
		} 
		return copy;
	}

	public static void print(boolean[][][] castle) {
		for (int y = 0; y < castle.length; y++) {
			for (int x = 0; x < castle[0].length; x++) {
				String s = "";
				for (int e = 0; e < 4; e++) {
					if (castle[y][x][e]) s += "0";
					else s += "1";
				}
				s =  ""+Integer.parseInt(s, 2);
				System.out.print(" " + s);
			}
			System.out.println();
		}
	}

	public static boolean[][][] removeWall(boolean[][][] castle, int room, int wall) {
		int x = castle[0].length;
		int y = castle.length;
		int[] lc = location(room, x, y);
		boolean[][][] n = copyOf3Dim(castle);

		// System.out.println(Arrays.toString(lc));

		if (n[lc[1]][lc[0]][wall]) return n; 

		if (lc[0] == x - 1 && wall == 1) {return n; }
		else if (lc[0] == 0 && wall == 3) {return n; }
		else if (lc[1] == 0 && wall == 2) {return n; }
		else if (lc[1] == y - 1&& wall == 0) {return n; };

		n[lc[1]][lc[0]][wall] = true;

		switch (wall) {
			case 0:
				n[lc[1] + 1][lc[0]][2] = true;
				break;
			case 1:
				n[lc[1]][lc[0] + 1][3] = true;
				break;
			case 2:
				n[lc[1] - 1][lc[0]][0] = true;
				break;
			case 3:
				n[lc[1]][lc[0] - 1][1] = true;
				break;
		}

		return n;

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