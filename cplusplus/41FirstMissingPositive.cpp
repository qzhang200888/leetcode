class Solution {
public:
    int firstMissingPositive(vector<int>& nums) {
        unordered_set<int> myset;
        for (int i = 0; i < nums.size(); ++i) {
            myset.insert(nums.at(i));
        }
        
        int i = 1;
        while (myset.find(i) != myset.end())
            ++i;
        
        return i;
    }
};
