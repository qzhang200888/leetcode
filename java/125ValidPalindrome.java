class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0)
            return true;
        char[] chars = s.toCharArray();
        int start = 0, end = chars.length - 1;
        while (start < end) {
            if (!Character.isLetterOrDigit(chars[start]))
                ++start;
            if (!Character.isLetterOrDigit(chars[end]))
                --end;
            if (Character.isLetterOrDigit(chars[start]) &&
                Character.isLetterOrDigit(chars[end])) {
                if (Character.toLowerCase(chars[start]) != Character.toLowerCase(chars[end]))
                    return false;
                ++start;
                --end;
            }
        }
        
        return true;
    }
}
