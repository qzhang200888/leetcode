class Solution {
    void permute(int[] nums, Set<Integer> set, List<Integer> lst, List<List<Integer>> res) {
        if (set.size() == nums.length) {
            res.add(new ArrayList<>(lst));
            return;
        }
        
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i]))
                continue;
            lst.add(nums[i]);
            set.add(nums[i]);
            permute(nums, set, lst, res);
            lst.remove(lst.size() - 1);
            set.remove(nums[i]);
        }
    } 
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        
        Set<Integer> set = new HashSet<>();
        List<Integer> lst = new ArrayList<>();
        
        permute(nums, set, lst, res);
        
        return res;
    }
}
