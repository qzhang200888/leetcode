//slow version
class Solution {
    public int shortestSubarray(int[] A, int K) {
        if (A == null || A.length == 0)
            return 0;
        
        long preSum = 0;
        TreeMap<Long, Integer> map = new TreeMap<>();
        map.put((long)0, -1);
        
        int res = A.length + 1;
        for (int i = 0; i < A.length; ++i) {
            preSum += A[i];
            Map<Long, Integer> subMap = map.subMap((long)Integer.MIN_VALUE, false, preSum - K, true);
            List<Long> deleteKeys = new ArrayList<>();
            for (Long key: subMap.keySet()) {
                int index = map.get(key);
                if (i - index < res)
                    res = i - index;
                deleteKeys.add(key);
            }
            
            for (long key: deleteKeys)
                map.remove(key);
            
            map.put(preSum, i);
        }
        
        if (res <= A.length)
            return res;
        
        return -1;
    }
}
