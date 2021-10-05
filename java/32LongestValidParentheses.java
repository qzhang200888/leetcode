class Solution {
    public int longestValidParentheses(String s) {
        if (s == null)
            return 0;
            
        int max = 0;
        int leftCount = 0;
        int rightCount = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == ')') {
                ++rightCount;
                if (rightCount > leftCount) {
                    leftCount = 0;
                    rightCount = 0;
                } else if (rightCount == leftCount) {
                    max = Math.max(max, 2 * rightCount);
                }
            } else {
                ++leftCount;
            }
            

        }
 
        leftCount = 0;
        rightCount = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            char c = s.charAt(i);
            if (c == '(') {
                ++leftCount;
                if (leftCount > rightCount) {
                    leftCount = 0;
                    rightCount = 0;
                } else if (rightCount == leftCount)  {
                    max = Math.max(max, 2 * leftCount);
                }
            } else {
                ++rightCount;
            }
            

        }
        
        return max;
    }
}

=============================

class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        int[] prev = new int[s.length()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (!stack.isEmpty()) {
                int cur = stack.pop();
                int newLength = i - cur + 1;
                if (cur > 0)
                    newLength += prev[cur - 1];
                prev[i] = newLength;
                if (newLength > max)
                    max = newLength;
            }
        }
        
        return max;
    }
}
