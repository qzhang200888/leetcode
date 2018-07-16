class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        TreeMap<Long, Integer> tMap = new TreeMap<>();
        long preSum = 0;
        int count = 0;
        tMap.put((long)0, 1);
        for (int i = 0; i < nums.length; ++i) {
            preSum += nums[i];
            
            Map<Long, Integer> subMap = tMap.subMap(preSum - upper, true, preSum - lower, true);
            for (long key: subMap.keySet()) {
                count += subMap.get(key);
            }
            
            int ct = tMap.getOrDefault(preSum, 0);
            tMap.put(preSum, ct + 1);
        }
        
        return count;
    }
}
