class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null) 
            return 0;
        
        int start = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            nums[start++] = nums[i];
        }
        
        return start;
    }
}

///////////////////////////////////////////////////////

class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if (j == nums.length - 1 || nums[j] < nums[j + 1]) {
                nums[i++] = nums[j];
            }
            ++j;
        }

        return i;
    }
}
