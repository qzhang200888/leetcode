class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        map<int, vector<int>> m;
        int presum = 0;
        int res = 0;
        for (int i = 0; i < nums.size(); ++i) {
            presum += nums[i];
            
            if (presum == k)
                ++res;

            if (m.find(presum - k) != m.end()) {
                res += m.find(presum - k)->second.size();
            }
            
            if (m.find(presum) == m.end())
                m[presum] = vector<int>();
            
            m[presum].push_back(i);
        }
        
        return res;
    }
};
