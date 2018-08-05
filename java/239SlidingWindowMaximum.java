class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k || k <= 0)
            return new int[0];
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < k - 1; ++i) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        int[] res = new int[nums.length - k + 1];
        for (int i = k - 1; i < nums.length; ++i) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            res[i - k + 1] = map.lastKey();
            
            if (map.get(nums[i - k + 1]) == 1)
                map.remove(nums[i - k + 1]);
            else map.put(nums[i - k + 1], map.get(nums[i - k + 1]) - 1);
        }
        
        return res;
    }
}
