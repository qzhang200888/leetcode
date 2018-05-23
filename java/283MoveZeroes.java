class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        
        int start = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0)
                nums[start++] = nums[i];
        }
        
        while (start < nums.length)
        {
            nums[start++] = 0;
        }
    }
}
