class Solution {
    
    int longestSubArray(char[] chars, int start, int end, int k) {
        int[] count = new int[26];
        for (int i = start; i <= end; ++i) {
            ++count[chars[i] - 'a'];
        }
        
        while (start <= end && count[chars[start] - 'a'] < k)
            ++start;
        
        while (start <= end && count[chars[end] - 'a'] < k)
            --end;
        
        for (int i = start + 1; i <= end; ++i) {
            if (count[chars[i] - 'a'] < k) {
                int res = 0;
                
                int upper = i + 1;
                while (upper <= end && count[chars[upper] - 'a'] < k)
                    ++upper;
                
                if (upper <= end)
                    res = Math.max(res, longestSubArray(chars, upper, end, k));
                
                res = Math.max(res, longestSubArray(chars, start, i - 1, k));
                
                return res;
            }
        }
        
        return end - start + 1;
    }
    
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() < k)
            return 0;
        
        char[] chars = s.toCharArray();

        return longestSubArray(chars, 0, chars.length - 1, k);
    }
}
