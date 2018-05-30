class Solution {    
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        
        int[][] dp = new int[matrix.length][matrix[0].length];
        
        int max = 0;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                    continue;
                }
                
                if (i > 0) {
                    dp[i][j] = dp[i-1][j] + 1;
                } else {
                    dp[i][j] = 1;
                }
                
                int h = dp[i][j];
                int k = j;
                while (k >= 0 && matrix[i][k] != '0') {
                    h = Math.min(h, dp[i][k]);
                    if ((j - k + 1) * h > max)
                        max = (j - k + 1) * h;
                    --k;
                }
            }
        }
        
        return max;
    }
}
