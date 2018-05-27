class Solution {    
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; ++i)
            sum += nums[i];
        if (sum % 2 != 0)
            return false;

        sum /= 2;
        boolean[][] ans = new boolean[sum + 1][nums.length + 1];
        for (int j = 0; j <= nums.length; j++) {
            ans[0][j] = true;
        }
        
        for (int j = 1; j <= nums.length; ++j) {
            for (int i = 1; i <= sum; ++i) {
                if (i < nums[j-1])
                    continue;
                
                ans[i][j] = ans[i - nums[j-1]][j-1] || ans[i][j - 1];
            }
            
            if (ans[sum][j])
                return true;
        }
        
        return false;
    }
}

// used a 1-dimensional array

class Solution {    
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; ++i)
            sum += nums[i];
        if (sum % 2 != 0)
            return false;

        sum /= 2;
        boolean[] ans = new boolean[sum + 1];
        ans[0] = true;
        
        for (int j = 1; j <= nums.length; ++j) {
            for (int i = sum; i > 0; --i) {
                if (i < nums[j-1])
                    continue;
                
                ans[i] = ans[i - nums[j-1]] || ans[i];
            }
            
            if (ans[sum])
                return true;
        }
        
        return false;
    }
}
