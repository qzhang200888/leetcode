class Solution {
    void combinationSum2(int[] candidates, int target, int pos, List<Integer> lst, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(lst));
            return;
        }
        
        if (pos >= candidates.length)
            return;

        if (candidates[pos] <= target) {
            lst.add(candidates[pos]);
            combinationSum2(candidates, target - candidates[pos], pos + 1, lst, res);
            lst.remove(lst.size() - 1);
        }
        
        while (pos < candidates.length - 1 && candidates[pos] == candidates[pos + 1])
            ++pos;
        
        combinationSum2(candidates, target, pos + 1, lst, res);
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>> ();
        List<Integer> lst = new ArrayList<Integer>();
        
        Arrays.sort(candidates);
        combinationSum2(candidates, target, 0, lst, res);
        
        return res;
    }
}
