class Solution {
    void subsetsWithDup(int[] nums, int pos, List<Integer> lst, List<List<Integer>> output) {
        if (pos >= nums.length) {
            output.add(new ArrayList(lst));
            return;
        }
        
        int cur = nums[pos];
        lst.add(cur);
        
        subsetsWithDup(nums, pos + 1, lst, output);
        
        lst.remove(lst.size() - 1);
        while (pos < nums.length && nums[pos] == cur)
            ++pos;
        subsetsWithDup(nums, pos, lst, output);
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null)
            return null;
        
        if (nums.length == 0)
            return new ArrayList<>();
        
        Arrays.sort(nums);
        
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> lst = new ArrayList<Integer>();
        
        subsetsWithDup(nums, 0, lst, output);
        
        return output;
    }
}
