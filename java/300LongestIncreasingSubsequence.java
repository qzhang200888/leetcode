class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] d = new int[nums.length];
        d[0] = 1;
        int max = 1;
        
        for (int i = 1; i < nums.length; ++i) {
            d[i] = 1;
            for (int j = i - 1; j >= 0; --j) {
                if (nums[i] > nums[j]) {
                    d[i] = Math.max(d[i], d[j] + 1);
                }
            }
            
            if (d[i] > max)
                max = d[i];
        }
        
        return max;
    }
}
