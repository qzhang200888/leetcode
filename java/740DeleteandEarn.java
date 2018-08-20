class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + nums[i]);
        }
        
        List<Integer> lst = new ArrayList<>();
        for (int val: map.keySet())
            lst.add(val);
        
        Collections.sort(lst);
        int[] earns = new int[lst.size()];
        for (int i = 0; i < earns.length; ++i) {
            if (i == 0) {
                earns[i] = map.get(lst.get(0));
            } else {
                if (lst.get(i) - lst.get(i-1) > 1)
                    earns[i] = earns[i-1] + map.get(lst.get(i));
                else if (i == 1) 
                    earns[i] = Math.max(earns[i-1], map.get(lst.get(i)));
                else earns[i] = Math.max(earns[i-1], earns[i-2] + map.get(lst.get(i)));
            }
        }
        
        return earns[lst.size() - 1];
    }
}
