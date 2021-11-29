class Solution {
    int helper(int n, Map<Integer, Integer> map) {
        if (n == 1)
            return 0;
        if (n == Integer.MAX_VALUE)
            return 32;

        if (map.containsKey(n))
            return map.get(n);

        int step;
        if (n % 2 == 0)
            step = helper(n / 2, map) + 1;
        else {
            step = helper(n - 1, map) + 1;
            step = Math.min(step, helper(n + 1, map) + 1);
        }
        
        map.put(n, step);
        return step;
    }
    
    public int integerReplacement(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        return helper(n, map) ;
    }
}
