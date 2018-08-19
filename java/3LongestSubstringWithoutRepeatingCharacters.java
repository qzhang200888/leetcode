class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len < 2)
            return len;
        
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int max = 0, start = 0;
        for (int i = 0; i < len; ++i) {
            if (map.containsKey(chars[i])) {
                if (i - start > max)
                    max = i - start;
                
                int pos = map.get(chars[i]);
                while (start < pos)
                    map.remove(chars[start++]);
                ++start;
            } else if (i == len - 1 && len - start > max)
                max = len - start;
            
            map.put(chars[i], i);
        }
        
        return max;
    }
}
