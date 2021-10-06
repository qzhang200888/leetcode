class Solution {
    void combinationSum(int[] candidates, int target, int sum, int index, List<List<Integer>> res, List<Integer> lst) {
        if (index >= candidates.length)
            return;

        if (sum + candidates[index] > target)
            return;

        if (sum + candidates[index] == target) {
            List<Integer> newLst = new ArrayList<>();
            for (int i: lst)
                newLst.add(i);
            newLst.add(candidates[index]);
            res.add(newLst);
            return;
        }
        
        combinationSum(candidates, target, sum, index + 1, res, lst);
        lst.add(candidates[index]);
        sum += candidates[index];
        combinationSum(candidates, target, sum, index, res, lst);
        lst.remove(lst.size() - 1);
        sum -= candidates[index];
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, target, 0, 0, res, lst);
        
        return res;
    }
}
