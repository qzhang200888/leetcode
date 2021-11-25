

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0)
            return -1;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        grid[0][0] = 1;
    
        int len = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int[] elem = queue.poll();
                int row = elem[0];
                int col = elem[1];
                if (row == grid.length - 1 && col == grid[0].length - 1)
                    return len;
            
                if (row > 0 && grid[row-1][col] == 0) {
                    queue.offer(new int[]{row-1, col});
                    grid[row-1][col] = 1;
                }
                
                if (col > 0 && grid[row][col-1] == 0) {
                    queue.offer(new int[]{row, col-1});
                    grid[row][col-1] = 1;
                }
                
                if (col > 0 && row > 0 && grid[row-1][col-1] == 0) {
                    queue.offer(new int[]{row-1, col-1});
                    grid[row-1][col-1] = 1;
                }
                
                if (row < grid.length - 1 && grid[row+1][col] == 0) {
                    queue.offer(new int[]{row+1, col});
                    grid[row+1][col] = 1;
                }
                
                if (row < grid.length - 1 && col > 0 && grid[row+1][col-1] == 0) {
                    queue.offer(new int[]{row+1, col-1});
                    grid[row+1][col-1] = 1;
                }
                
                if (col < grid[0].length - 1 && grid[row][col+1] == 0) {
                    queue.offer(new int[]{row, col+1});
                    grid[row][col+1] = 1;
                }
                
                if (col < grid[0].length - 1 && row > 0 && grid[row-1][col+1] == 0) {
                    queue.offer(new int[]{row-1, col+1});
                    grid[row-1][col+1] = 1;
                }
                
                if (col < grid[0].length - 1 && row < grid.length - 1  && grid[row+1][col+1] == 0) {
                    queue.offer(new int[]{row+1, col+1});
                    grid[row+1][col+1] = 1;
                }
            }
            
            ++len;
        }
        
        return -1;
    }
}


===============================================================================

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0)
            return -1;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[0][0] = true;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        
        int len = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int[] elem = queue.poll();
                int row = elem[0];
                int col = elem[1];
                if (row == grid.length - 1 && col == grid[0].length - 1)
                    return len;
            
                if (row > 0 && grid[row-1][col] == 0 && !visited[row-1][col]) {
                    queue.offer(new int[]{row-1, col});
                    visited[row-1][col] = true;
                }
                
                if (col > 0 && grid[row][col-1] == 0 && !visited[row][col-1]) {
                    queue.offer(new int[]{row, col-1});
                    visited[row][col-1] = true;
                }
                
                if (col > 0 && row > 0 && grid[row-1][col-1] == 0 && !visited[row-1][col-1]) {
                    queue.offer(new int[]{row-1, col-1});
                    visited[row-1][col-1] = true;
                }
                
                if (row < grid.length - 1 && grid[row+1][col] == 0 && !visited[row+1][col]) {
                    queue.offer(new int[]{row+1, col});
                    visited[row+1][col] = true;
                }
                
                if (row < grid.length - 1 && col > 0 && grid[row+1][col-1] == 0 && !visited[row+1][col-1]) {
                    queue.offer(new int[]{row+1, col-1});
                    visited[row+1][col-1] = true;
                }
                
                if (col < grid[0].length - 1 && grid[row][col+1] == 0 && !visited[row][col+1]) {
                    queue.offer(new int[]{row, col+1});
                    visited[row][col+1] = true;
                }
                
                if (col < grid[0].length - 1 && row > 0 && grid[row-1][col+1] == 0 && !visited[row-1][col+1]) {
                    queue.offer(new int[]{row-1, col+1});
                    visited[row-1][col+1] = true;
                }
                
                if (col < grid[0].length - 1 && row < grid.length - 1  && grid[row+1][col+1] == 0 && !visited[row+1][col+1]) {
                    queue.offer(new int[]{row+1, col+1});
                    visited[row+1][col+1] = true;
                }
            }
            
            ++len;
        }
        
        return -1;
    }
}
