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


======================================================

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[] {-1, -1};
        
        int start = findPoint(nums, target, 0, nums.length - 1, true);
        if (start == -1)
            return new int[] {-1, -1};

        int end = findPoint(nums, target, start + 1, nums.length - 1, false);

        if (end == -1)
            return new int[] {start, start};
        
        return new int[] {start, end};
    }
    
    public int findPoint(int[] nums, int target, int start, int end, boolean findStart) {
        if (start > end)
            return -1;

        while (start < end - 1) {
            int mid = start + (end - start) / 2;
            
            if (target < nums[mid])
                end = mid;
            else if (target > nums[mid])
                start = mid;
            else if (findStart)
                end = mid;
            else start = mid;
        }
        
        if (findStart) {
            if (target == nums[start])
                return start;
            if (target == nums[end])
                return end;
        } else {
            if (target == nums[end])
                return end;
            if (target == nums[start])
                return start;
        }
        
        return -1;
    }
}
