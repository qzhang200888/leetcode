// O(n) and O(n) solution

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

// O(n) and O(1) solution

class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1;
        int j = T.length() - 1;
        
        while (i >= 0 && j >= 0) {
            int count = 0;
            char c1 = S.charAt(i);
            while (i >= 0) {
                if (c1 != '#' && count == 0)
                    break;
                if (c1 == '#')
                    ++count;
                else --count;
                --i;
                if (i >= 0)
                    c1 = S.charAt(i);
            }
            
            count = 0;
            char c2 = T.charAt(j);
            while (j >= 0) {
                if (c2 != '#' && count == 0)
                    break;
                if (c2 == '#')
                    ++count;
                else --count;
                --j;
                if (j >= 0)
                    c2 = T.charAt(j);
            }
            
            if (i >= 0 && j >= 0 && c1 != c2)
                return false;
            --i;
            --j;
        }
        
        if (i >= 0) {
            int count = 0;
            char c1 = S.charAt(i);
            while (i >= 0) {
                if (c1 != '#' && count == 0)
                    break;
                if (c1 == '#')
                    ++count;
                else --count;
                --i;
                if (i >= 0)
                    c1 = S.charAt(i);
            }
        }
        
        if (j >= 0) {
            int count = 0;
            char c2 = T.charAt(j);
            while (j >= 0) {
                if (c2 != '#' && count == 0)
                    break;
                if (c2 == '#')
                    ++count;
                else --count;
                --j;
                if (j >= 0)
                    c2 = T.charAt(j);
            }            
        }
        
        return i == j;
    }
}
