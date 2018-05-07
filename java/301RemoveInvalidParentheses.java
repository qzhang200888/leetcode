class Solution {
    void removeInvalidParentheses(String s, int pos, int leftCount, String res, Set<String> set) {
        if (pos == s.length()) {
            if (leftCount == 0)
                set.add(res);
            return;
        }
        
        char c = s.charAt(pos);
        if (c == '(') {
            removeInvalidParentheses(s, pos + 1, leftCount, res, set);
            removeInvalidParentheses(s, pos + 1, leftCount + 1, res + c, set);
        } else if (c == ')') {
            if (leftCount > 0)
                removeInvalidParentheses(s, pos + 1, leftCount - 1, res + c, set);
            removeInvalidParentheses(s, pos + 1, leftCount, res, set);
        } else {
            removeInvalidParentheses(s, pos + 1, leftCount, res + c, set);
        }
    }
    
    public List<String> removeInvalidParentheses(String s) {
        Set<String> set = new HashSet<String>();        
        removeInvalidParentheses(s, 0, 0, "", set);
        
        int max = 0;
        for (String str: set) {
            if (str.length() > max)
                max = str.length();
        }
        
        List<String> res = new ArrayList<String>();
        for (String str: set) {
            if (str.length() == max)
                res.add(str);
        }
        
        return res;
    }
}
