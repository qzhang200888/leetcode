class Solution {
public:
    int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        
        int* nums = new int[n + 1];
        nums[0] = nums[1] = 1;
        for (int i = 2; i <= n; ++i) {
            nums[i] = 0;
            for (int k = 1; k <= i; ++k) {
                nums[i] += nums[k - 1] * nums[i - k];
            }
        }
        
        int res = nums[n];
        delete[] nums;
        return res;
    }
};
