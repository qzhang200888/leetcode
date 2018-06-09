class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        
        int s = 0, e = nums.length - 1;
        int mid = 0;
        while (s < e) {
            mid = s + (e - s) / 2;
            if (mid == s)
                break;
            
            boolean even = (mid % 2 == 0);
            if (even) {
                if (nums[mid] == nums[mid - 1])
                    e = mid;
                else if (nums[mid] == nums[mid + 1])
                    s = mid;
                else return nums[mid];
            } else {
                if (nums[mid] == nums[mid + 1])
                    e = mid;
                else if (nums[mid] == nums[mid - 1])
                    s = mid;
                else return nums[mid];    
            }
        }
        
        if (mid == 0)
            return nums[mid];
        
        if (nums[mid] == nums[mid - 1])
            return nums[mid + 1];
        
        if (nums[mid] == nums[mid + 1])
            return nums[mid - 1];
        
        return nums[mid];
    }
}
