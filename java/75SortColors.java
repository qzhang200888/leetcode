class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        
        int start = 0, end = nums.length - 1, cur = 0;
        
        while (cur <= end) {
            if (nums[cur] == 0) {
                if (start < cur) {
                    int tmp = nums[start];
                    nums[start] = 0;
                    nums[cur] = tmp;
                } else ++cur;
                ++start;
            } else if (nums[cur] == 2) {
                if (end > cur) {
                    int tmp = nums[end];
                    nums[end] = 2;
                    nums[cur] = tmp;
                } else ++cur;
                --end;              
            } else ++cur;
        }
    }
}
