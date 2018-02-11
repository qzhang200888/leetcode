class Solution {
public:
    int trap(vector<int>& height) {
        int max = 0;
        int max_index = 0;
        
        for (int i = 0; i < height.size(); ++i) {
            if (height[i] > max) {
                max = height[i];
                max_index = i;
            }
        }
        
        int res = 0;
        int pre_height = 0;
        
        for (int i = 0; i < max_index; ++i) {
            if (height[i] > pre_height) {
                pre_height = height[i];
            } else {
                res += pre_height - height[i];
            }
        }
 
        pre_height = 0;
        for (int i = height.size() - 1; i > max_index; --i) {
            if (height[i] > pre_height) {
                pre_height = height[i];
            } else {
                res += pre_height - height[i];
            }
        }
        
        return res;
    }
};
