class Solution {
public:
    bool isValid(string s) {
        stack<char> stc;
        for (int i = 0; i < s.size(); ++i) {
            char c = s.at(i);
            if (c == '(' || c == '[' || c == '{') {
                stc.push(c);
            } else if (c == '}') {
                if (stc.empty() || stc.top() != '{')
                    return false;
                stc.pop();
            } else if (c == ']') {
                if (stc.empty() || stc.top() != '[')
                    return false;
                stc.pop();
            } else if (c == ')') {
                if (stc.empty() || stc.top() != '(')
                    return false;
                stc.pop();
            }
        }
        
        return stc.empty();
    }
};
