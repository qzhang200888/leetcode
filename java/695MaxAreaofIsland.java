class Solution {
    int area(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length)
            return 0;

        if (grid[r][c] == 0)
            return 0;
        grid[r][c] = 0;
        int a = 1;
        a += area(grid, r - 1, c);
        a += area(grid, r + 1, c);
        a += area(grid, r, c - 1);
        a += area(grid, r, c + 1);
        
        return a;
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                int a = area(grid, i, j);
                if (max < a)
                    max = a;
            }
        }
        
        return max;
    }
}
