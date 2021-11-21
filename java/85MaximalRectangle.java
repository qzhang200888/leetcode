
class Solution {
    int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int idx = stack.pop();
                int area = 0;
                if (stack.isEmpty()) {
                    area = heights[idx] * i;
                } else {
                    area = heights[idx] * (i - stack.peek() - 1);
                }
                if (area > max) {
                    max = area;
                }
            }
            
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            int area = 0;
            if (stack.isEmpty()) {
                area = heights[idx] * heights.length;
            } else {
                area = heights[idx] * (heights.length - stack.peek() - 1);
            }
            if (area > max) {
                max = area;
            }
        }
        
        return max;
    }
    
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int[] heights = new int[matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < heights.length; ++j) {
                if (matrix[i][j] == '0')
                    heights[j] = 0;
                else if (i == 0)
                    heights[j] = 1;
                else ++heights[j];
            }
            
            int rec = largestRectangleArea(heights);
            if (rec > max) {
                max = rec;
            }
        }
        
        return max;
    }
}


==============================================================================

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
