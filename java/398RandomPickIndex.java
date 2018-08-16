class Solution {
    Map<Integer, List<Integer>> map;
    Random r;
    
    public Solution(int[] nums) {
        map = new HashMap<>();
        r = new Random();
        for (int i = 0; i < nums.length; ++i) {
            if (!map.containsKey(nums[i]))
                map.put(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        List<Integer> lst = map.get(target);
        return lst.get(r.nextInt(lst.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
