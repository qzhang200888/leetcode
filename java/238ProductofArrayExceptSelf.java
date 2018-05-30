class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null)
            return null;
        
        int[] res = new int[nums.length];
        if (nums.length == 0)
            return res;
        
        int prod = 1;
        for (int i = 0; i < nums.length; ++i) {
            res[i] = prod;
            prod *= nums[i];
        }
        
        prod = 1;
        for (int i = nums.length - 1; i >= 0; --i) {
            res[i] *= prod;
            prod *= nums[i]; 
        }
        
        return res;
    }
}
