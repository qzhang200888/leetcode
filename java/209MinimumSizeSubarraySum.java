class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null)
            return 0;
        int res = nums.length + 1;
        int sum = 0;
        int start = 0;
        
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            while (sum >= s) {
                if (i - start + 1 < res)
                    res = i - start + 1;
                
                sum -= nums[start];
                ++start;
            }
        }
        
        if (res <= nums.length)
            return res;
        
        return 0;
    }
}
