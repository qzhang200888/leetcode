class Solution {
    void bankOfIsland(int[][] grid, Queue<int[]> queue, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length)
            return;
        if (grid[row][col] != 1)
            return;
        
        grid[row][col] = 2;
        boolean isBank = false;
        if (row > 0) {
            if (grid[row - 1][col] == 0)
                isBank = true;
            else bankOfIsland(grid, queue, row - 1, col);
        }
        
        if (col > 0) {
            if (grid[row][col - 1] == 0)
                isBank = true;
            else bankOfIsland(grid, queue, row, col - 1);
        }
        
        if (row < grid.length - 1) {
            if (grid[row + 1][col] == 0)
                isBank = true;
            else bankOfIsland(grid, queue, row + 1, col);
        }
        
        if (col < grid[0].length - 1) {
            if (grid[row][col + 1] == 0)
                isBank = true;
            else bankOfIsland(grid, queue, row, col + 1);
        }
        
        if (isBank) {
            queue.add(new int[]{row, col});
            grid[row][col] += 3;
        }
    }
    
    public int shortestBridge(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    bankOfIsland(grid, queue, i, j);
                    break;
                }
            }
            
            if (queue.size() > 0)
                break;
        }

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int[] pos = queue.poll();
                int r = pos[0];
                int c = pos[1];

                if (r > 0) {
                    if (grid[r-1][c] == 0) {
                        queue.add(new int[]{r-1, c});
                        grid[r-1][c] += 3;
                    } else if (grid[r-1][c] == 1)
                        return step;
                }

                if (c > 0) {
                    if (grid[r][c-1] == 0) {
                        queue.add(new int[]{r, c-1});
                        grid[r][c-1] += 3;
                    } else if (grid[r][c-1] == 1)
                        return step;
                }
                if (r < grid.length - 1) {
                    if (grid[r+1][c] == 0) {
                        queue.add(new int[]{r+1, c});
                        grid[r+1][c] += 3;
                    } else if (grid[r+1][c] == 1)
                        return step;
                }
                if (c < grid[0].length - 1) {
                    if (grid[r][c+1] == 0) {
                        queue.add(new int[]{r, c+1});
                        grid[r][c+1] += 3;
                    } else if (grid[r][c+1] == 1)
                        return step;
                }
            }
            ++step;
        }
        
        return 0;
    }
}
