class Solution {
public:
    int integerBreak(int n) {
        vector<int> v;
        
        v.push_back(1);
        v.push_back(1);
        for (int i = 2; i <= n; ++i) {
            int prod = INT_MIN;
            for (int j = 1; j <= i / 2; ++j) {
                if (prod < v[j] * v[i - j])
                    prod = v[j] * v[i - j];              
            }
            
            if (prod < i && i < n)
                prod = i;
            
            v.push_back(prod);
        }
        
        return v[n];
    }
};
