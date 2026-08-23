class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i <= nums.length - 3; ++i) {
            for (int j = i +1; j <= nums.length - 2; ++j) {
                int low = j + 1;
                int high = nums.length -1;
                while (low < high) {
                    long sum = (long)nums[i] + (long)nums[j] + (long)nums[low] + (long)nums[high];
                    if (sum == (long)target) {
                        List<Integer> lst = new ArrayList<>();
                        lst.add(nums[i]);
                        lst.add(nums[j]);
                        lst.add(nums[low]);
                        lst.add(nums[high]);
                        set.add(lst);
                        ++low;
                    } else if (sum < (long)target) {
                        ++low;
                    } else {
                        --high;
                    }
                }
            }
        }
        for (List<Integer> ele: set) {
            res.add(ele);
        }

        return res;
    }
}
