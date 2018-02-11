class Solution {
public:
    int pivotIndex(vector<int>& nums) {
        int right_sum = 0;
        for (int i = 0; i < nums.size(); ++i) {
            right_sum += nums[i];
        }
        
        int left_sum = 0;
        for (int i = 0; i < nums.size(); ++i) {
            right_sum -= nums[i];
            if (i > 0)
                left_sum += nums[i-1];
            if (left_sum == right_sum)
                return i;
        }
        
        return -1;
    }
};
