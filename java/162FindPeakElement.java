class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null)
            return 0;
        int i = 0;
        while (i < nums.length - 1 && nums[i] < nums[i+1])
            ++i;
        
        return i;
    }
}
