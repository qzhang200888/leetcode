class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0)
            return true;
        
        boolean[] res = new boolean[nums.length];
        res[0] = true;
        for (int i = 1; i < nums.length; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (res[j] && nums[j] >= i - j) {
                    res[i] = true;
                    break;
                }
            }
        }
        
        return res[nums.length - 1];
    }
}
