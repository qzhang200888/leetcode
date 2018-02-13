class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        vector<int> v(amount + 1, 0);
        v[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            v[i] = INT_MAX;
            for (int j = 0; j < coins.size(); ++j) {
                if (i - coins[j] >= 0) {
                    if (v[i - coins[j]] != INT_MAX && v[i] > v[i - coins[j]] + 1) {
                        v[i] = v[i - coins[j]] + 1;
                    }
                }
            }
        }
        
        return v[amount] == INT_MAX? -1 : v[amount];
    }
};
