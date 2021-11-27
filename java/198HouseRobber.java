class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        
        int[] robbed = new int[nums.length];
        robbed[nums.length - 1] = nums[nums.length - 1];
        robbed[nums.length - 2] = nums[nums.length - 2];
        robbed[nums.length - 3] = nums[nums.length - 3] + robbed[nums.length - 1];
        
        for (int i = nums.length - 4; i >= 0; --i) {
            robbed[i] = nums[i];
            if (robbed[i+2] > robbed[i+3]) {
                robbed[i] += robbed[i+2];
            } else {
                robbed[i] += robbed[i+3];
            }
        }
        
        return Math.max(robbed[0], robbed[1]);
    }
}
