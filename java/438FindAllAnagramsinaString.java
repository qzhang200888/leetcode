class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null || s.length() == 0 || s.length() < p.length())
            return new ArrayList<>();

        int[] letters = new int[26];
        char[] patterns = p.toCharArray();
        char[] strs = s.toCharArray();
        
        for (char c: patterns) {
            ++letters[c - 'a'];
        }
        
        int len = patterns.length;
        int count = len;
        int i = 0;
        for (; i < len; ++i) {
            --letters[strs[i] - 'a'];
            if (letters[strs[i] - 'a'] >= 0)
                --count;
        }
        
        List<Integer> lst = new ArrayList<>();
        if (count == 0)
            lst.add(0);

        for (; i < strs.length; ++i) {
            ++letters[strs[i - len] - 'a'];
            if (letters[strs[i - len] - 'a'] > 0)
                ++count;

            --letters[strs[i] - 'a'];
            if (letters[strs[i] - 'a'] >= 0)
                --count;

            if (count == 0) {
                lst.add(i - len + 1);
            }
        }
        
        return lst;
    }
}

==============================================

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> lst = new ArrayList<Integer>();
        if (s == null || p == null || s.length() < p.length())
            return lst;
        
        int[] letters = new int[26];
        char[] schars = s.toCharArray();
        char[] pattern = p.toCharArray();
        for (int i = 0; i < pattern.length; ++i) {
            ++letters[pattern[i] - 'a'];
        }
        
        int count = p.length();
        int start = 0, end = 0;
        for (; end < pattern.length; ++end) {
            --letters[schars[end] - 'a'];
            if (letters[schars[end] - 'a'] >= 0)
                --count;
        }
        
        if (count == 0)
            lst.add(start);
        
        ++start;
        
        while (end < s.length()) {
            ++letters[schars[start - 1] - 'a'];
            if (letters[schars[start - 1] - 'a'] > 0)
                ++count;
            
            --letters[schars[end] - 'a'];
            if (letters[schars[end] - 'a'] >= 0)
                --count;
            
            if (count == 0)
                lst.add(start);

            ++start;
            ++end;
        }
        
        return lst;
    }
}
