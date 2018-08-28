public class Solution {
    int numWays(int n, int k, int curPos, int prevColor, int pre2Color) {
        if (curPos == n) {
            if (prevColor != 0 && prevColor == pre2Color)
                return k - 1;
            return k;
        }
        
        int count = 0;
        for (int i = 1; i <= k; ++i) {
            if (prevColor == i && pre2Color == i) {
                continue;
            }
            count += numWays(n, k, curPos + 1, i, prevColor);
        }
            
        return count;
    }
    
    /**
     * @param n: non-negative integer, n posts
     * @param k: non-negative integer, k colors
     * @return: an integer, the total number of ways
     */
    public int numWays(int n, int k) {
        return numWays(n, k, 1, 0, 0);
    }
}
