class Solution {
    int findTargetSumWays(int[] nums, int S, int pos) {
        if (pos >= nums.length) {
            if (S == 0)
                return 1;
            return 0;
        }
        
        return findTargetSumWays(nums, S - nums[pos], pos + 1) +
            findTargetSumWays(nums, S + nums[pos], pos + 1);
    }
    
    public int findTargetSumWays(int[] nums, int S) {
        return findTargetSumWays(nums, S, 0);
    }
}
