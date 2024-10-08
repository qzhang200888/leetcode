class Solution {
    public int largestRectangleArea(int[] heights) {
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
}

=======================================

class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;
        
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < heights.length; ++i) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i);
                continue;
            }
            
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int h = heights[stack.pop()];
                if (stack.isEmpty()) {
                    max = Math.max(max, h * i);
                } else
                    max = Math.max(max, h * (i - stack.peek() - 1));
            }
            
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int h = heights[stack.pop()];
            if (stack.isEmpty()) {
                max = Math.max(max, h * heights.length);
            } else
                max = Math.max(max, h * (heights.length - stack.peek() - 1));
        }
        
        return max;
    }
}
