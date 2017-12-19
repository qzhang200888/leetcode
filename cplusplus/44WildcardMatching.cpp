class Solution {
public:
    bool isMatch(string s, string p) {
        vector<vector<bool>> matchingTable(s.size() + 1, vector<bool>(p.size() + 1, false));
        matchingTable[0][0] = true;
        
        for (int j = 0; j < p.size(); ++j) {
            if (p.at(j) == '*') {
                matchingTable[0][j + 1] = matchingTable[0][j];
            }
        }
        
        for (int i = 0; i < s.size(); ++i) {
            for (int j = 0; j < p.size(); ++j) {
                if (p.at(j) != '*') {
                    if (p.at(j) == '?' || s.at(i) == p.at(j))
                        matchingTable[i+1][j+1] = matchingTable[i][j];
                    else matchingTable[i+1][j+1] = false;
                } else {
                    if (matchingTable[i+1][j] || matchingTable[i][j+1])
                        matchingTable[i+1][j+1] = true;
                    else matchingTable[i+1][j+1] = false;
                }
            }
        }
        
        return matchingTable[s.size()][p.size()];
    }
};
