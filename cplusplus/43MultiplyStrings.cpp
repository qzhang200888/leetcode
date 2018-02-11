class Solution {
public:
    string multiply(string num1, string num2) {
        if (num1.size() == 0 || num2.size() == 0)
            return "0";
        
        vector<int> res = vector<int>(num1.size() + num2.size(), 0);
        int offset = 1;
        int carrier = 0;
        for (int i = num1.size() - 1; i >= 0; --i) {
            int n1 = num1.at(i) - '0';
            for (int j = num2.size() - 1; j >= 0; --j) {
                int n2 = num2.at(j) - '0';
                int prod = n1 * n2;
                
                res[num1.size() - offset + 1 + j] += prod + carrier;
                carrier = res[num1.size() - offset + 1 + j] / 10;
                res[num1.size() - offset + 1 + j] %= 10;
            }
            
            int pos = num1.size() - offset;
            while (carrier > 0) {
                res[pos] += carrier;
                res[pos] %= 10;
                carrier /= 10;
                --pos;
            }

            ++offset;
        }

        string s = "";
        int i = 0;
        while (res[i] == 0 && i < res.size() - 1)
            ++i;
        
        for (; i < res.size(); ++i)
            s += '0' + res[i];
        
        return s;
    }
};
