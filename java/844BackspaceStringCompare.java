class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s1 = new Stack<>();
        for (int i = 0; i < S.length(); ++i) {
            char c = S.charAt(i);
            if (c != '#')
                s1.push(c);
            else if (!s1.isEmpty())
                s1.pop();
        }

        Stack<Character> s2 = new Stack<>();
        for (int i = 0; i < T.length(); ++i) {
            char c = T.charAt(i);
            if (c != '#')
                s2.push(c);
            else if (!s2.isEmpty())
                s2.pop();
        }
        
        if (s1.size() != s2.size())
            return false;
        while (!s1.empty()) {
            char c1 = s1.pop();
            char c2 = s2.pop();
            if (c1 != c2)
                return false;
        }
        
        return true;
    }
}
