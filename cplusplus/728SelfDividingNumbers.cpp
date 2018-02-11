class Solution {
    bool isSelfDividingNumber(int i) {
        int k = i;
        while (k > 0) {
            int digit = k % 10;
            if (digit == 0 || i % digit != 0)
                return false;
            k /= 10;
        }
        
        return true;
    }
public:
    vector<int> selfDividingNumbers(int left, int right) {
        vector<int> res;
        for (int i = left; i <= right; ++i) {
            if (isSelfDividingNumber(i))
                res.push_back(i);
        }
        
        return res;
    }
};
