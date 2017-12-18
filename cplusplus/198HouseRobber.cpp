class Solution {
public:
    int rob(vector<int>& nums) {
        int first = 0, second = 0;
        for (int i = 0; i < nums.size(); ++i) {
            int sum = first + nums.at(i);
            first = second;
            if (sum >= second) {
                second = sum;
            }
        }
        
        if (first > second)
            return first;
        
        return second;
    }
};
