// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
import java.io.*;
class TV2 {
    static class Pair{
        int x; int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static boolean[][] visited;
    static int[][] grid;
    static int l; static int h;
    static int F;
    static int startX; static int startY;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());
        ArrayList<Pair> flood = new ArrayList<Pair>();
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            flood.add(new Pair(a,b));
        }
        F = N;
        grid = new int[l][h];
        for(int i=0;i<l;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<h;j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[l][h];
        for(Pair P : flood){
            startX = P.x-1;
            startY = P.y-1;
            dfs(P.x-1,P.y-1);
        }
        int notFlood = l*h-F;
        if(notFlood >= F){
            out.println("yipee!");
        }
        else{
            out.println("Oh gee golly, I wish this didn't happen");
        }
        //System.out.println(F);
        br.close();
        out.close();
    }
    static void dfs(int x, int y){
        if(x<0 || x>=l || y<0 || y>=h || visited[x][y]){
            return;
        }
        visited[x][y] = true;
        if(x != startX || y!=startY) F++;
        boolean leftWall = (grid[x][y] & 1)==1 ? true : false;
        boolean upWall = ((grid[x][y]>>1) & 1)==1 ? true : false;
        boolean rightWall = ((grid[x][y]>>2) & 1)==1 ? true : false;
        boolean downWall = ((grid[x][y]>>3) & 1)==1 ? true : false;
        
        if(!leftWall){
            dfs(x,y-1);
        }
        if(!rightWall){
            dfs(x,y+1);
        }
        if(!upWall){
            dfs(x-1,y);
        }
        if(!downWall){
            dfs(x+1,y);
        }
        

        
        
    }
}