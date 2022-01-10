class Solution {
    void mark(int row, int[][] M, boolean[] visited) {
        if (visited[row])
            return;
        visited[row] = true;
        for (int j = 0; j < M[row].length; ++j) {
            if (M[row][j] == 1) {
                mark(j, M, visited);
            }
        }
    }
    
    public int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int count = 0;
        for (int i = 0; i < M.length; ++i) {
            if (!visited[i]) {
                ++count;
                mark(i, M, visited);
            }
        }
        
        return count;
    }
}
