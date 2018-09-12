class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 2; ++i) {
            int start = i + 1;
            int end = nums.length - 1;
            
            while (start < end) {
                if ((i == 0 && start == 1 && end == nums.length - 1) ||
                    Math.abs(res - target) > Math.abs(nums[i] + nums[start] + nums[end] - target)) {
                    res = nums[i] + nums[start] + nums[end];
                    if (res == target)
                        return target;
                }
                
                if (nums[i] + nums[start] + nums[end] < target)
                    ++start;
                else --end;
            }
        }
        
        return res;
    }
}
