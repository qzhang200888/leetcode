class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0)
            return 0;
        
        char[] hays = haystack.toCharArray();
        char[] needles = needle.toCharArray();
        
        for (int i = 0; i <= hays.length - needles.length; ++i) {
            int j = i;
            for (; j < i + needles.length; ++j) {
                if (hays[j] != needles[j - i])
                    break;
            }
            
            if (j == i + needles.length)
                return i;
        }
        
        return -1;
    }
}
