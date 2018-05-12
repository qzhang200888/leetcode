class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int[][] rec = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; ++i)
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] == '0')
                    rec[i][j] = 0;
                else if (i == 0 || j == 0)
                    rec[i][j] = 1;
                else {
                    rec[i][j] = Math.min(rec[i][j - 1], Math.min(rec[i - 1][j - 1], rec[i - 1][j])) + 1;
                }
                
                if (max < rec[i][j] )
                    max = rec[i][j];
            }
        
        return max * max;
    }
}
