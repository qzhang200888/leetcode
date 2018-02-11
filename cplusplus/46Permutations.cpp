class Solution {
    vector<vector<int>> permute(vector<int>& nums, vector<bool>& selected, vector<vector<int>> &res, int pos) {
        if (pos == nums.size())
            return res;

        vector<vector<int>> output;
        for (int i = 0; i < selected.size(); ++i) {
            if (!selected[i]) {
                vector<vector<int>> list;
                selected[i] = true;
                if (pos == 0) {
                    vector<int> v;
                    v.push_back(nums[i]);
                    list.push_back(v);
                } else {
                    for (int j = 0; j < res.size(); ++j) {
                        vector<int> v = res[j];
                        v.push_back(nums[i]);
                        list.push_back(v);
                    }
                }
                
                vector<vector<int>> new_list = permute(nums, selected, list, pos + 1);
                output.insert(output.end(), new_list.begin(), new_list.end() );
                
                selected[i] = false;
            }
        }
        
        return output;
    }
    
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> v;
        if (nums.size() == 0)
            return v;
        
        vector<bool> selected(nums.size(), false);
        
        return permute(nums, selected, v, 0);
    }
};
