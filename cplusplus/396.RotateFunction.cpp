class Solution {
public:
    int maxRotateFunction(vector<int>& A) {
        int sum = 0;
        int weighted_sum = 0;
        for (int i = 0; i < A.size(); ++i) {
            sum += A[i];
            weighted_sum += A[i] * i;
        }
        
        int res = weighted_sum;
        for (int i = 1; i < A.size(); ++i) {
            weighted_sum += sum - A.size() * A[A.size() - i];
            if (res < weighted_sum)
                res = weighted_sum;
        }
        
        return res;
    }
};
