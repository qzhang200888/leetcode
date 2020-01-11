class Solution {
    public int[] decompressRLElist(int[] nums) {
        int length = 0;
        for (int i = 0; i < nums.length; i += 2) {
            length += nums[i];
        }
        
        int[] res = new int[length];
        
        int k = 0;
        for (int i = 0; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i]; ++j)
                res[k++] = nums[i + 1];
        }
        
        return res;
    }
}
