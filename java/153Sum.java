class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (-nums[i] > nums[j] + nums[k]) {
                    ++j;
                } else if (-nums[i] < nums[j] + nums[k]) {
                    --k;
                } else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1])
                        ++j;
                    ++j;
                    while (j < k && nums[k] == nums[k - 1])
                        --k;
                    --k;
                }
            }
        }
        
        return res;
    }
}
