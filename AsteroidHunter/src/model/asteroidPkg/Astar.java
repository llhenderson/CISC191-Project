import java.util.*;

// Program to implement A* algorithm
public class Astar 
{
    // Structure to hold coordinate pair
    static class Pair 
    {
        int first;
        int second;

        Pair(int initFirst, int initSecond)
        {
            this.first = initFirst;
            this.second = initSecond;
        }
    }

    // Structure holding necessary parameters
    static class Cell
    {

        // Row & Column index of its parent
        int parent_i;
        int parent_j;

        // f = g + h
        int f;
        int g;
        int h;

        Cell()
        {
            parent_i = -1;
            parent_j = -1;
            f = Integer.MAX_VALUE;
            g = Integer.MAX_VALUE;
            h = Integer.MAX_VALUE;
        }
    }

    // Node used in priority queue
    static class Node implements Comparable<Node>
    {
        int f;
        int row;
        int col;

        Node(int initF, int initRow, int initCol)
        {
            this.f = initF;
            this.row = initRow;
            this.col = initCol;
        }

        @Override public int compareTo(Node other)
        {
            if (this.f != other.f)
            {
                return Integer.compare(this.f, other.f);
            }

            if (this.row != other.row)
            {
                return this.row - other.row;
            }

            return this.col - other.col;
        }
    }

    static final int ROW = 9;
    static final int COL = 10;

    // Method to check whether given cell (row, col) is valid
    static boolean isValid(int row, int col)
    {
        // Returns true if row & col numbers are within range
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL);
    }

    // Method to check if given cell is blocked or not
    static boolean isUnBlocked(int[][] grid, int row, int col)
    {
        // Returns true if cell is not blocked, else false
        return grid[row][col] == 0;
    }

    // Method to check if target cell has been reached
    static boolean atTarget(int row, int col, Pair target)
    {
        return row == target.first && col == target.second;
    }

    // Manhattan method to calculate the 'h' heuristics
    static int calculateHValue(int row, int col, Pair target)
    {
        return Math.abs(row - target.first) + Math.abs(col - target.second);
    }

    // Method to trace the path from source to target
    static void tracePath(Cell[][] cellDetails, Pair target)
    {
        // System.out.println("The Path is ");

        int row = target.first;
        int col = target.second;

        Stack<Pair> path = new Stack<>();

        while (!(cellDetails[row][col].parent_i == row &&
                cellDetails[row][col].parent_j == col))
        {
            path.push(new Pair(row, col));

            int tempRow = cellDetails[row][col].parent_i;
            int tempCol = cellDetails[row][col].parent_j;

            row = tempRow;
            col = tempCol;

        }

        path.push(new Pair(row, col));

        while (!path.isEmpty())
        {
            Pair p = path.pop();
            System.out.print("-> (" + p.first + ", " + p.second + ") ");
        }

        System.out.println();
    }

    // Method to find shortest path between source and target cell
    // using A* algorithm
    static void aStarAlgo(int[][] grid, Pair source, Pair target)
    {
        // If source is out of range
        if (!isValid(source.first, source.second))
        {
            System.out.println("Source is invalid"); //
            return;
        }

        // If target is out of range
        if (!isValid(target.first, target.second))
        {
            System.out.println("Target is invalid"); //
            return;
        }

        // Either source or target is blocked
        if (!isUnBlocked(grid, source.first, source.second) ||
            !isUnBlocked(grid, target.first, target.second))
        {
            System.out.println("Source or target is blocked"); //
            return;
        }

        // If target cell is same as source cell
        if (atTarget(source.first, source.second, target))
        {
            System.out.println("We're at target"); // Replace with enemy saying "Target acquired"
            return;
        }

        // Create closed list & initialize it to false, meaning no
        // cells have been included. 
        boolean[][] closedList = new boolean[ROW][COL];

        // Initialize new 2D Cell array to hold cell details
        Cell[][] cellDetails = new Cell[ROW][COL];

        for (int i = 0; i < ROW; i++)
        {
            for (int j = 0; j < COL; j++)
            {
                cellDetails[i][j] = new Cell();
            }
        }

        // Initialize parameters of starting node
        int i = source.first;
        int j = source.second;

        cellDetails[i][j].f = 0;
        cellDetails[i][j].g = 0;
        cellDetails[i][j].h = 0;
        cellDetails[i][j].parent_i = i;
        cellDetails[i][j].parent_j = j;

        /**
         * Create open list having information as <f, <i, j>>,
         * where f = g + h and i & j are row and col index of that cell.
         * Open list is implemented using PriorityQueue (min-heap) ordered by f value.
         */
        PriorityQueue<Node> openList = new PriorityQueue<>();

        // Put starting cell on open list and set its "f" as 0
        openList.offer(new Node(0, i, j));

        // Initialize boolean as false since target is not reached
        boolean foundTarget = false;

        while (!openList.isEmpty())
        {
            Node p = openList.poll();

            // Add vertex to closed list
            i = p.row;
            j = p.col;

            if (closedList[i][j])
            {
                continue;
            }

            closedList[i][j] = true;

            /**
             * Generate all 8 successors of this cell
             */
            // Store the "g", "h", and "f" values of successors
            int gNew;
            int hNew;
            int fNew;

            // Directions corresponding to the 8 neighbors
            int[] dRow = { -1, 1, 0, 0, -1, -1, 1, 1 };
            int[] dCol = { 0, 0, 1, -1, 1, -1, 1, -1 };

            for (int dir = 0; dir < 8; dir++)
            {
                int newRow = i + dRow[dir];
                int newCol = j + dCol[dir];

                // Only process cell if valid
                if (isValid(newRow, newCol))
                {
                    // Check if target cell is same as current successor
                    if (atTarget(newRow, newCol, target))
                    {
                        // Set Parent of the target cell
                        cellDetails[newRow][newCol].parent_i = i;
                        cellDetails[newRow][newCol].parent_j = j;

                        System.out.println("The target cell is found"); //

                        tracePath(cellDetails, target);

                        foundTarget = true;
                        return;
                    }
                    // Perform following if successor unblocked or not on closed list
                    else if (!closedList[newRow][newCol] && isUnBlocked(grid, newRow, newCol))
                    {
                        // Add diagonal movement if PlayerShip can move diagonally
                        // if (Math.abs(dRow[dir]) + Math.abs(dCol[dir]) == 2)
                        // then gNew = cellDetails[i][j].g + 1.414, else add gNew here
                        
                        gNew = cellDetails[i][j].g + 1;

                        hNew = calculateHValue(newRow, newCol, target);

                        fNew = gNew + hNew;

                        if (cellDetails[newRow][newCol].f == Integer.MAX_VALUE ||
                            cellDetails[newRow][newCol].f > fNew)
                        {
                            openList.offer(new Node(fNew, newRow, newCol));

                            // Update details of cell
                            cellDetails[newRow][newCol].f = fNew;
                            cellDetails[newRow][newCol].g = gNew;
                            cellDetails[newRow][newCol].h = hNew;
                            cellDetails[newRow][newCol].parent_i = i;
                            cellDetails[newRow][newCol].parent_j = j;
                        }
                    }
                }
            }
        }

        // Output message when target cell not found
        if (!foundTarget)
        {
            System.out.println("Failed to find target");
        }
    }

    public static void main(String[] args)
    {
        int[][] grid = {
            { 0, 1, 0, 0, 0, 0, 1, 0, 0, 0 },
            { 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 },
            { 0, 0, 0, 1, 0, 0, 1, 0, 1, 0 },
            { 1, 1, 0, 1, 0, 1, 1, 1, 1, 0 },
            { 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
            { 0, 1, 0, 0, 0, 0, 1, 0, 1, 1 },
            { 0, 1, 1, 1, 1, 0, 1, 1, 1, 0 },
            { 0, 1, 0, 0, 0, 0, 1, 0, 0, 0 },
            { 0, 0, 0, 1, 1, 1, 0, 1, 1, 0 }
        };
        
        // Source is left-most bottom-most corner
        Pair source = new Pair(8, 0);

        Pair target = new Pair(0, 0);

        aStarAlgo(grid, source, target);
    }
}
