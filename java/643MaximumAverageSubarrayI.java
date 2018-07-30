class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length < k)
            return 0;
        long maxSum = Integer.MIN_VALUE, curSum = 0;
        for (int i = 0; i < k - 1; ++i) {
            curSum += nums[i];
        }
        
        for (int i = k - 1; i < nums.length; ++i) {
            curSum += nums[i];
            if (maxSum < curSum)
                maxSum = curSum;
            curSum -= nums[i - k + 1];
        }
        
        return ((double) maxSum) / k;
    }
}
