class Solution {
    public int findDuplicate(int[] nums) {
        if (nums.length < 2)
            return 0;
        
        Arrays.sort(nums);
        
        int start = 0, end = nums.length - 1;
        
        while (start < end - 1) {
            int mid = (start + end) / 2;
            if (nums[mid] < mid + 1)
                end  = mid;
            else start = mid;
        }
        
        return nums[end];
    }
}
