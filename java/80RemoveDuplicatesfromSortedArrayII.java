class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int cur, count = 0, j = 0;
        cur = nums[0];
        count = 1;
        j = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == cur) {
                ++count;
            } else {
                cur = nums[i];
                count = 1;
            }

            if (count < 3) {
                nums[j++] = cur;
            }
        }

        return j;
    }
}
