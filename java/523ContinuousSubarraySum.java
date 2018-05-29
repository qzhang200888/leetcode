class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null)
            return false;
        if (nums.length <= 1) {
            return false;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            int tmp = sum;
            if (k != 0)
                tmp = tmp % k;
            if (map.containsKey(tmp) && i - map.get(tmp) > 1)
                return true;
            if (!map.containsKey(tmp))
                map.put(tmp, i);
        }
        
        return false;
    }
}
