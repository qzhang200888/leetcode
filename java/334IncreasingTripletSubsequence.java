class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums==null || nums.length<3) return false;
        
        int min = nums[0];
        int second = Integer.MAX_VALUE;
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            } else if (nums[i] > min && nums[i] < second) {
                second = nums[i];
            } else if (nums[i] > second)
                return true;
        }
        
        return false;
    }
}
