class Solution {
public:
    bool isIdealPermutation(vector<int>& A) {
        int max = INT_MIN;
        for (int i = 0; i < A.size(); ++i) {
            if (max > A[i])
                return false;
            if (i > 0 && A[i-1] > max)
                max = A[i-1];
        }
        
        return true;
    }
};
