class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        if (k == 0)
            return new int[3];
        
        int[] sum = new int[nums.length - k + 1];
        int[] leftMax = new int[nums.length - k + 1];
        int total = 0, max = 0;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; ++i) {
            total += nums[i];
            if (i >= k) 
                total -= nums[i - k];
                if (i >= k - 1) {
                    sum[i - k + 1] = total;
                if (max < sum[i - k + 1]) {
                    maxIndex = i - k + 1;
                    max = sum[i - k + 1];
                }
                leftMax[i - k + 1] = maxIndex;
            }
        }
        
        max = 0;
        int[] rightMax = new int[nums.length - k + 1];
        for (int i = sum.length - 1; i >= 0; --i) {
            if (max < sum[i]) {
                max = sum[i];
                maxIndex = i;
            }
            rightMax[i] = maxIndex;          
        }
        
        int[] res = new int[] {-1, -1, -1};
        for (int j = k; j < sum.length - k; ++j) {
            if (res[0] == - 1 || sum[leftMax[j - k]] + sum[j] + sum[rightMax[j + k]] > sum[res[0]] + sum[res[1]] + sum[res[2]]) {
                res[0] = leftMax[j - k];
                res[1] = j;
                res[2] = rightMax[j + k];
            }
        }
        
        return res;
    }
}
