class Solution {
    void subsets(int[] nums, int pos, List<Integer> lst, List<List<Integer>> res) {
        if (pos == nums.length) {
            res.add(new ArrayList(lst));
            return;
        }
        
        subsets(nums, pos + 1, lst, res);
        lst.add(nums[pos]);
        subsets(nums, pos + 1, lst, res);
        lst.remove(lst.size() - 1);
    } 
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null)
            return res;
        
        List<Integer> lst = new ArrayList<>();
        subsets(nums, 0, lst, res);
        
        return res;
    }
}
