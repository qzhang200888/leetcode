class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        if (strs.size() == 0)
            return "";
        
        string res ="";
        for (int i = 0; i < strs.at(0).length();  ++i) {
            char c = strs.at(0).at(i);
            for (int j = 1; j < strs.size(); ++j) {
                if (i >= strs.at(j).length())
                    return res;
                if (c != strs.at(j).at(i))
                    return res;
            }
            
            res += c;
        }
        
        return res;
    }
};
