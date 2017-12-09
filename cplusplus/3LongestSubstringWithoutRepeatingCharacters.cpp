class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        if (s.length() == 0)
            return 0;
        
        unordered_map<char, int> map;
        int length = 0, start = 0;
        
        for (int i = 0; i < s.length(); ++i) {
            char c = s.at(i);
            if ( map.find(c) == map.end()) {
                map.insert(make_pair(c, i));
                if (length < i - start + 1)
                    length = i - start + 1;
            } else {
                int pos = map.find(c)->second;
                for (int j = start; j <= pos; ++j) {
                    if (map.find(s.at(j))->second <= pos) {
                        map.erase(s.at(j));
                    }
                }
                
                start = pos + 1;
                map.insert(make_pair(c, i));
            }
        }
        
        return length;
    }
};
