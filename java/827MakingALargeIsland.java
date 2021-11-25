class Solution {
    boolean isCandidate(int[][] grid, int r, int c) {
        if (grid[r][c] != 0)
            return false;
        int count = 0;
        if (r > 0 && grid[r-1][c] == 1)
            ++count;
        if (c > 0 && grid[r][c-1] == 1)
            ++count;
        
        if (r < grid.length - 1 && grid[r+1][c] == 1)
            ++count;
        if (c < grid[0].length - 1 && grid[r][c+1] == 1)
            ++count;
        
        return count > 1;
    }
    
    int area(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length)
            return 0;
        if (grid[r][c] != 1)
            return 0;
        
        grid[r][c] = -1;
        int count = 1;
        count += area(grid, r - 1, c);
        count += area(grid, r + 1, c);
        count += area(grid, r, c - 1);
        count += area(grid, r, c + 1);
        
        return count;
    }
    
    void restore(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length)
            return;
        if (grid[r][c] != -1)
            return;
        
        grid[r][c] = 1;
        restore(grid, r - 1, c);
        restore(grid, r + 1, c);
        restore(grid, r, c - 1);
        restore(grid, r, c + 1);
    }
    
    public int largestIsland(int[][] grid) {
        List<int[]> candidates = new ArrayList<>();
        boolean foundZero = false;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (isCandidate(grid, i, j))
                    candidates.add(new int[]{i, j});
                if (grid[i][j] == 0)
                    foundZero = true;
            } 
        }
        
        if (candidates.isEmpty()) {
            int ar = maxAreaOfIsland(grid);
            if (foundZero)
                ++ar;
            return ar;
        }
        
        int max = 0;
        for (int[] pos: candidates) {
            int i = pos[0];
            int j = pos[1];
            int ar = area(grid, i+1, j) + 1;
            ar += area(grid, i-1, j);
            ar += area(grid, i, j - 1);
            ar += area(grid, i, j + 1);
            
            if (ar > max)
                max = ar;
            restore(grid, i+1, j);
            restore(grid, i-1, j);
            restore(grid, i, j - 1);
            restore(grid, i, j + 1);
        }
        
        return max;
    }
    
    int getArea(int[][] grid, int r, int c) {
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
    
    int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                int a = getArea(grid, i, j);
                if (max < a)
                    max = a;
            }
        }
        
        return max;
    }
}
