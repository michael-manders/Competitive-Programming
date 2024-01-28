/* 
ID: mjmande1
LANG: JAVA
TASK: milk3
*/

import java.io.*;
import java.util.*;

class milk3 {
	public static void main (String[] args) throws IOException {
		Kattio io = new Kattio("milk3");
		int a = io.nextInt();
		int b = io.nextInt();
		int c = io.nextInt();

		int [] cap=new int [3];
		cap[0] = a;
		cap[1] = b;
		cap[2] = c;

		ArrayList<Integer> list=new ArrayList<Integer>();
        Stack<Node> stack=new Stack<Node>();
        boolean [][][] flag=new boolean [21][21][21];
        stack.add(new Node(0,0,cap[2]));
        int [][] comb={{0,1,2},{0,2,1},{1,0,2},{1,2,0},{2,0,1},{2,1,0}};
        while (!stack.empty()) {
            Node n=stack.pop();
            if (n.milk[0]==0 && !list.contains(n.milk[2])) {
                list.add(n.milk[2]);
            }
            flag[n.milk[0]][n.milk[1]][n.milk[2]]=true;
            Node newN;
            for (int i=0;i<comb.length;i++) {
                newN=pour(n,comb[i][0],comb[i][1],cap[comb[i][1]]);
                if (!flag[newN.milk[0]][newN.milk[1]][newN.milk[2]]) {
                    stack.push(newN);
                }
            }
        }
        Collections.sort(list);
        String s="";
        for (int i=0;i<list.size();i++) {
            s=s+list.get(i)+" ";
        }
        s=s.substring(0,s.length()-1);
        io.println(s);
        io.close();

	}

	private static class Node {
        int [] milk=new int [3];
        
        public Node(Node n) {
            this.milk[0]=n.milk[0];
            this.milk[1]=n.milk[1];
            this.milk[2]=n.milk[2];
        }
        
        public Node (int i0, int i1, int i2) {
            this.milk[0]=i0;
            this.milk[1]=i1;
            this.milk[2]=i2;
        }
    }
    
    public static Node pour (Node n, int from, int to, int toCap) {
        Node newN=new Node(n);
        int toPour=toCap-newN.milk[to];
        if (toPour>newN.milk[from]) {
            toPour=newN.milk[from];
        }
        newN.milk[to]=newN.milk[to]+toPour;
        newN.milk[from]=newN.milk[from]-toPour;
        return newN;
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