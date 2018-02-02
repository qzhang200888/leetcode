class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        vector<int> k_values;
        vector<int> res;
        
        int i = 0;
        int max = INT_MIN;
        for (; i < nums.size() && i < k; ++i) {
            if (max < nums[i]) {
                max = nums[i];
            }
            
            k_values.push_back(nums[i]);
        }
        
        if (i < k || i == 0) {
            return res;
        }
        
        res.push_back(max);
        
        for (; i < nums.size(); ++i) {
            if (nums[i - k] >= max && nums[i - k] > nums[i]) {
                max = INT_MIN;
                for (int j = i - k + 1; j <= i; ++j)
                    if (max < nums[j])
                        max = nums[j];              
            } else if (max < nums[i]) {
                max = nums[i];
            }
            
            res.push_back(max);
        }
        
        return res;
    }
};
