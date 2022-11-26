import java.util.*;

class escape {
    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);
        int w = io.nextInt(), h = io.nextInt();

        ArrayList<String> lines = new ArrayList<String>();

        io.nextLine();
        for (int i = 0; i < h; i++) {
            lines.add(io.nextLine());
        }

        // convert to binary array
        int[][] grid = new int[h][w];

        int[] start = new int[2];
        int[] food = new int[2];
        int[] exit = new int[2];

        for (int i = 0; i < h; i++) {
            String row = lines.get(i);
            for (int j = 0; j < w; j++) {
                char character = row.charAt(j);
                if (character == '#') grid[i][j] = 0;
                else if (character == '.') grid[i][j] = 1;
                else if (character == 'S') {
                    start[0] = j;
                    start[1] = i;
                    grid[i][j] = 1;
                }
                else if (character == 'F') {
                    food[0] = j;
                    food[1] = i;
                    grid[i][j] = 1;
                }
                else if (character == 'E') {
                    exit[0] = j;
                    exit[1] = i;
                    grid[i][j] = 1;
                }
            }
        }

        Point start1 = new Point(start[1], start[0]);
        Point middle = new Point(food[1], food[0]);
        Point end = new Point(exit[1], exit[0]);

        ROW = w;
        COL = h;

        // System.out.println(Arrays.toString(food));

        int dist1 = BFS(grid, start1, middle);
        int dist2 = BFS(grid, middle, end);

        // System.out.println(Arrays.deepToString(grid));

        if (dist1 > -1 && dist2 > -1) {
            System.out.printf("Connor can get the food in %d steps\n", dist1);
            System.out.printf("Connor can get to the exit in %d steps", dist2);
            

        }
        else {
            System.out.println("Connor cannot escape!");

        }

        

    }

    static int ROW = 5;
    static int COL = 5;
     
    // To store matrix cell coordinates
    static class Point
    {
        int x;
        int y;
     
        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    };
     
    // A Data Structure for queue used in BFS
    static class queueNode
    {
        Point pt; // The coordinates of a cell
        int dist; // cell's distance of from the source
     
        public queueNode(Point pt, int dist)
        {
            this.pt = pt;
            this.dist = dist;
        }
    };
     
    // check whether given cell (row, col)
    // is a valid cell or not.
    static boolean isValid(int row, int col)
    {
        // return true if row number and
        // column number is in range
        return (row >= 0) && (row < ROW) &&
               (col >= 0) && (col < COL);
    }
     
    // These arrays are used to get row and column
    // numbers of 4 neighbours of a given cell
    static int rowNum[] = {-1, 0, 0, 1};
    static int colNum[] = {0, -1, 1, 0};
     
    // function to find the shortest path between
    // a given source cell to a destination cell.
    static int BFS(int mat[][], Point src,
                                Point dest)
    {
        // check source and destination cell
        // of the matrix have value 1
        if (mat[src.x][src.y]   != 1 ||
            mat[dest.x][dest.y] != 1)
            return -1;
     
        boolean [][]visited = new boolean[ROW][COL];
         
        // Mark the source cell as visited
        visited[src.x][src.y] = true;
     
        // Create a queue for BFS
        Queue<queueNode> q = new LinkedList<>();
         
        // Distance of source cell is 0
        queueNode s = new queueNode(src, 0);
        q.add(s); // Enqueue source cell
     
        // Do a BFS starting from source cell
        while (!q.isEmpty())
        {
            queueNode curr = q.peek();
            Point pt = curr.pt;
     
            // If we have reached the destination cell,
            // we are done
            if (pt.x == dest.x && pt.y == dest.y)
                return curr.dist;
     
            // Otherwise dequeue the front cell
            // in the queue and enqueue
            // its adjacent cells
            q.remove();
     
            for (int i = 0; i < 4; i++)
            {
                int row = pt.x + rowNum[i];
                int col = pt.y + colNum[i];
                 
                // if adjacent cell is valid, has path
                // and not visited yet, enqueue it.
                if (isValid(row, col) &&
                        mat[row][col] == 1 &&
                        !visited[row][col])
                {
                    // mark cell as visited and enqueue it
                    visited[row][col] = true;
                    queueNode Adjcell = new queueNode
                                 (new Point(row, col),
                                       curr.dist + 1 );
                    q.add(Adjcell);
                }
            }
        }
     
        // Return -1 if destination cannot be reached
        return -1;
    }

}

