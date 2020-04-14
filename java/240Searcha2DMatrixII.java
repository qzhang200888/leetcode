class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        
        int i = 0, j = matrix[0].length - 1;
        while (true) {
            if (matrix[i][j] == target)
                return true;
            if (matrix[i][j] < target) {
                if (i == matrix.length - 1)
                    return false;
                ++i;    
            } else {
                if (j == 0)
                    return false;
                --j;
            }
        }
    }
}
