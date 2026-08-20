class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0)
            return true;
        
        boolean[] res = new boolean[nums.length];
        res[0] = true;
        for (int i = 1; i < nums.length; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (res[j] && nums[j] >= i - j) {
                    res[i] = true;
                    break;
                }
            }
        }
        
        return res[nums.length - 1];
    }
}

///////////////////////////////////////////////////

class Solution {
    public boolean canJump(int[] nums) {
        boolean[] res = new boolean[nums.length];
        res[nums.length - 1] = true;
        for (int i = nums.length - 2; i >= 0; --i) {
            res[i] = false;
            if (nums[i] == 0) {
                continue;
            }
            for (int j = i + 1; j <= i + nums[i]; ++j) {
                if (res[j]) {
                    res[i] = true;
                    break;
                }
            }
        }

        return res[0];
    }
}
