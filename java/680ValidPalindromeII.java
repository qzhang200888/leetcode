class Solution {
    boolean isPalindrome(char[] chars, int start, int end) {
        while (start < end) {
            if (chars[start] != chars[end])
                return false;
            ++start;
            --end;
        }
        
        return true;
    }
    
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0)
            return true;
        
        char[] chars = s.toCharArray();
        int start = 0, end = chars.length - 1;
        while (start < end) {
            if (chars[start] != chars[end])
                break;
            ++start;
            --end;
        }
        
        if (start >= end)
            return true;
        
        return isPalindrome(chars, start + 1, end) || isPalindrome(chars, start, end - 1);
    }
}
