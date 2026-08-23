class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = -1, diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; ++i) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int newDiff = Math.abs(target - nums[i] - nums[j] - nums[k]);
                if (newDiff < diff) {
                    res = nums[i] + nums[j] + nums[k];
                    diff = newDiff;
                    if (diff == 0) {
                        return res;
                    }
                }

                if (nums[i] + nums[j] + nums[k] < target) {
                    ++j;
                } else {
                    --k;
                }
            }
        }

        return res;
    }
}
