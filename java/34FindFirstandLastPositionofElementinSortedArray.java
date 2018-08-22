class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[] {-1, -1};
        
        int first = -1, last = -1;
                                                      
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target)
                end = mid;
            else start = mid + 1;
        }
                                                      
        if (nums[end] == target)
            first = end;
        
        start = 0;
        end = nums.length - 1;
        while (start < end - 1) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target)
                end = mid - 1;
            else start = mid;
        }
                                                      
        if (nums[end] == target)
            last = end;
        else if (nums[start] == target)
            last = start;
                                                      
        return new int[] {first, last};
    }
}
