public class Solution {
    /**
     * @param grid: a 2d boolean array
     * @param k: an integer
     * @return: the number of Islands
     */
    public int numsofIsland(boolean[][] grid, int k) {
        // Write your code here
        // write your code here
        int count = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j)
                if (grid[i][j] && destroy(grid, i, j) >= k) {
                    ++count;
                }
        }

        return count;
    }

    int destroy(boolean[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
            return 0;
        if (!grid[i][j])
            return 0;
        grid[i][j] = false;
        int ans = 1;
        ans += destroy(grid, i - 1, j);
        ans += destroy(grid, i + 1, j);
        ans += destroy(grid, i, j - 1);
        ans += destroy(grid, i, j + 1);

        return ans;
    }
}
