class Solution {
    void changeToZero(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length)
            return;
        if (j < 0 || j >= grid[0].length)
            return;
        
        if (grid[i][j] == '0')
            return;
        
        grid[i][j] = '0';
        changeToZero(grid, i - 1, j);
        changeToZero(grid, i + 1, j);
        changeToZero(grid, i, j - 1);
        changeToZero(grid, i, j + 1);
    }
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '1') {
                    ++count;
                    changeToZero(grid, i, j);
                }
            }
        }
        
        return count;
    }
}
