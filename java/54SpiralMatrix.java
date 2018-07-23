class Solution {
    List<Integer> spiralOrder(int[][] matrix, int offsetRow, int offsetCol) {
        List<Integer> res = new ArrayList<>();
        if (offsetRow > matrix.length - 1 - offsetRow ||
            offsetCol > matrix[0].length - 1 - offsetCol)
            return res;
        
        for (int i = offsetCol; i <= matrix[0].length - 1 - offsetCol; ++i)
            res.add(matrix[offsetRow][i]);
        
        for (int i = offsetRow + 1; i < matrix.length - 1 - offsetRow; ++i)
            res.add(matrix[i][matrix[0].length - 1 - offsetCol]);
        
        if (offsetRow < matrix.length - 1 - offsetRow)
            for (int i = matrix[0].length - 1 - offsetCol; i >= offsetCol; --i)
                res.add(matrix[matrix.length - 1 - offsetRow][i]);
    
        if (offsetCol < matrix[0].length - 1 - offsetCol)
            for (int i = matrix.length - 2 - offsetRow; i > offsetRow; --i)
                res.add(matrix[i][offsetCol]);
        
        res.addAll(spiralOrder(matrix, offsetRow + 1, offsetCol + 1));
        
        return res;
    }
    
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return new ArrayList<>();
        
        return spiralOrder(matrix, 0, 0);
    }
}
