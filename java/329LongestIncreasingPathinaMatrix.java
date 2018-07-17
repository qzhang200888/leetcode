class Solution {
    boolean isValid(int[][] matrix, int i, int j) {
        if (i< 0 || j < 0) return false;
        if (i >= matrix.length) return false;
        if (j >= matrix[i].length) return false;
        return true;
    }
    
    void longestIncreasingPath(int[][] matrix, int[][] paths, int i, int j) {
        if (paths[i][j] > 0)
            return;
        
        int length = 1;
        if (isValid(matrix, i - 1, j) && matrix[i - 1][j] < matrix[i][j]) {
            if (paths[i - 1][j] == 0)
                longestIncreasingPath(matrix, paths, i - 1, j);
            if (paths[i - 1][j] + 1 > length)
                length = paths[i - 1][j] + 1;
        }
        if (isValid(matrix, i + 1, j) && matrix[i + 1][j] < matrix[i][j]) {
            if (paths[i + 1][j] == 0)
                longestIncreasingPath(matrix, paths, i + 1, j);
            if (paths[i + 1][j] + 1 > length)
                length = paths[i + 1][j] + 1;
        }
        
        if (isValid(matrix, i, j + 1) && matrix[i][j + 1] < matrix[i][j]) {
            if (paths[i][j + 1] == 0)
                longestIncreasingPath(matrix, paths, i, j + 1);
            if (paths[i][j + 1] + 1 > length)
                length = paths[i][j + 1] + 1;
        } 
 
        if (isValid(matrix, i, j - 1) && matrix[i][j - 1] < matrix[i][j]) {
            if (paths[i][j - 1] == 0)
                longestIncreasingPath(matrix, paths, i, j - 1);
            if (paths[i][j - 1] + 1 > length)
                length = paths[i][j - 1] + 1;
        }
        
        paths[i][j] = length;
    }
    
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        
        int[][] paths = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                longestIncreasingPath(matrix, paths, i, j);
                if (paths[i][j] > max)
                    max = paths[i][j];
            }
        }
        
        return max;
    }
}
