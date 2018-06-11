class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2)
            return;
        int i = nums.length - 1;
        while (i > 0) {
            if (nums[i-1] < nums[i])
                break;
            --i;
        }
        
        if (i == 0) {
            int s = 0, e = nums.length - 1;
            while (s < e) {
                int tmp = nums[s];
                nums[s] = nums[e];
                nums[e] = tmp;
                ++s;
                --e;
            }
        } else {
            int s = i, e = nums.length - 1;
            while (s < e) {
                int mid = s + (e - s) / 2;
                if (mid == s)
                    break;
                
                if (nums[mid] <= nums[i-1])
                    e = mid - 1;
                else s = mid;
            }
            
            int tmp = nums[i-1];
            if (nums[e] > tmp) {
                nums[i-1] = nums[e];
                nums[e] = tmp;
            } else {
                nums[i-1] = nums[s];
                nums[s] = tmp;
            }
            
            s = i;
            e = nums.length - 1;
            while (s < e) {
                tmp = nums[s];
                nums[s] = nums[e];
                nums[e] = tmp;
                ++s;
                --e;
            }           
        }
    }
}
