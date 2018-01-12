class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        if (s.length() == 0)
            return 0;
        
        char first, second;
        int firstIndex = -1, secondIndex = -1, start = 0;
        int length = 0;
        
        for (int i = 0; i < s.length(); ++i) {
            char c = s.at(i);
            if (firstIndex == -1) {
                first = c;
                firstIndex = i;
                start = i;
            } else if (secondIndex == -1) {
                second = c;
                secondIndex = i;
            } else if (c == first) {
                firstIndex = i;
            } else if (c == second) {
                secondIndex = i;
            } else {
                if (secondIndex < firstIndex) {
                    second = c;
                    start = secondIndex + 1;
                    secondIndex = i;
                } else {
                    first = second;
                    second = c;
                    start = firstIndex + 1;
                    firstIndex = secondIndex;
                    secondIndex = i;
                }
            }
            
            if (length < i - start + 1)
                length = i - start + 1;
        }
        
        return length;
    }
};
