class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        TreeMap<Long, Integer> upper = new TreeMap<>();
        TreeMap<Long, Integer> lower = new TreeMap<>();
        
        double[] res = new double[nums.length - k + 1];
        int upperSize = 0, lowerSize = 0;
        int index = 0;
        
        for (int i = 0; i < nums.length; ++i) {
            int v;
            if (i >= k) {
                long key = nums[i - k];
                if (key >= upper.firstKey()) {
                    v = upper.get(key);
                    if (v == 1)
                        upper.remove(key);
                    else upper.put(key, v - 1);
                    --upperSize;
                } else {
                    v = lower.get(key);
                    if (v == 1)
                        lower.remove(key);
                    else lower.put(key, v - 1);
                    --lowerSize;
                }
            }
            
            if (lower.isEmpty() || (long)nums[i] > lower.lastKey()) {
                v = upper.getOrDefault((long)nums[i], 0);
                upper.put((long)nums[i], v + 1);
                ++upperSize;
            } else {
                v = lower.getOrDefault((long)nums[i], 0);
                lower.put((long)nums[i], v + 1);
                ++lowerSize;
            }
            
            if (upperSize - lowerSize > 1) {
                long ukey = upper.firstKey();                
                int val = upper.get(ukey);
                if (val == 1)
                    upper.remove(ukey);
                else upper.put(ukey, val - 1);
                
                v = lower.getOrDefault(ukey, 0);
                lower.put(ukey, v + 1);
                --upperSize;
                ++lowerSize;
            } else if (lowerSize > upperSize) {
                long lkey = lower.lastKey();                
                int val = lower.get(lkey);
                if (val == 1)
                    lower.remove(lkey);
                else lower.put(lkey, val - 1);
                
                v = upper.getOrDefault(lkey, 0);
                upper.put(lkey, v + 1);
                ++upperSize;
                --lowerSize;
            }
            
            if (i >= k - 1) {
                if (upperSize == lowerSize)
                    res[index++] = (upper.firstKey() + lower.lastKey()) / 2.0;
                else res[index++] = upper.firstKey();                
            }
        }
        
        return res;
    }
}
