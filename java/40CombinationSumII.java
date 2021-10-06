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

==========================================

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

        int newIndex = index + 1;
        while (newIndex < candidates.length && candidates[newIndex] == candidates[index])
            ++newIndex;
        combinationSum(candidates, target, sum, newIndex, res, lst);
        
        for (int i = index; i < newIndex; ++i) {
          lst.add(candidates[i]);
          sum += candidates[i];
          if (sum == target) {
              List<Integer> newLst = new ArrayList<>();
              for (int k: lst)
                  newLst.add(k);
              res.add(newLst);
              
              for (int j = i; j >= index; --j)
                  lst.remove(lst.size() - 1);
              return;            
          }
          combinationSum(candidates, target, sum, newIndex, res, lst);
        }
        
        for (int i = index; i < newIndex; ++i) {
          lst.remove(lst.size() - 1);
          sum -= candidates[i];
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, target, 0, 0, res, lst);

        return res;    
    }
}
