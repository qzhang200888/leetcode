class Solution {
public:
    string longestPalindrome(string s) {
        string res = "";
        for (int i = 0; i < s.length(); ++i) {
            for (int j = 0; j <= i && j < s.length() - i; ++j) {
                if (s.at(i - j) == s.at(i + j) ) {
                    if (res.length() < 2*j + 1)
                        res = s.substr(i - j, 2*j + 1);
                } else break;
            }
   
            for (int j = 0; j <= i && j < s.length() - i - 1; ++j) {
                if (s.at(i - j) == s.at(i + j + 1)) {
                    if (res.length() < 2*j + 2)
                        res = s.substr(i - j, 2*j + 2);
                } else break;
            }
            
        }
        
        return res;
    }
};
