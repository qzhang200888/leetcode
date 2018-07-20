class Solution {
    int paths(int[][] board, int i, int j, int[][] visited) {
        if (visited[i][j] >= 0)
            return visited[i][j];
        
        if (board[i][j] == 1) {
            visited[i][j] = 0;
            return 0;
        }
        
        if (i == board.length - 1 && j == board[i].length - 1) {
            visited[i][j] = 1;
            return 1;
        }
        
        int num = 0;
        if (i < board.length - 1)
            num += paths(board, i + 1, j, visited);
        
        if (j < board[i].length - 1)
            num += paths(board, i, j + 1, visited);
        
        visited[i][j] = num;
        
        return num;
    }
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null)
            return 0;
        
        int[][] visited = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int[] row: visited)
            Arrays.fill(row, -1);
        
        return paths(obstacleGrid, 0, 0, visited);
    }
}
