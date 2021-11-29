class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
    
    int atMost(int[] nums, int k)  {
        Map<Integer, Integer> map = new HashMap<>();
        int countWord = 0;
        int countArr = 0;
        int start = 0, end = 0;
        while (end < nums.length) {
            int i = nums[end];
            if (!map.containsKey(i)) {
                ++countWord;
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
            
            while (countWord > k && start <= end) {
                int j = nums[start];
                map.put(j, map.get(j) - 1);
                if (map.get(j) == 0) {
                    --countWord;
                    map.remove(j);
                }

                ++start;
            }
            
            countArr += end - start + 1;
            ++end;
        }
        
        return countArr;
    }
}
