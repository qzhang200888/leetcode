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
