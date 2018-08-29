class Solution {
    void permute(int[] nums, boolean[] selected, List<Integer> lst, List<List<Integer>> res) {
        if (lst.size() == nums.length) {
            res.add(new ArrayList<>(lst));
            return;
        }

        int i = 0;
        while (i < nums.length) {
            if (selected[i]) {
                ++i;
                continue;
            }
            
            lst.add(nums[i]);
            selected[i] = true;
            permute(nums, selected, lst, res);
            lst.remove(lst.size() - 1);
            selected[i] = false;
            
            while (i + 1 < nums.length && nums[i] == nums[i + 1])
                ++i;
            ++i;
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;

        Arrays.sort(nums);
        
        boolean[] selected = new boolean[nums.length];
        List<Integer> lst = new ArrayList<>();

        permute(nums, selected, lst, res);

        return res;        
    }
}
