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

==================================

class Solution {
    
    boolean isValid(char c) {
        return (c >= '0' && c <= '9') ||
            (c >= 'a' && c <= 'z') ||
            (c >= 'A' && c <= 'Z') ;
    }
    
    boolean compare(char c1, char c2) {
        if (c1 == c2)
            return true;
        if ( (c1 >= 'a' && c1 <= 'z')  && (c1 - 'a') == (c2 - 'A'))
            return true;
        if ((c1 >= 'A' && c1 <= 'Z')  && (c1 - 'A') == (c2 - 'a'))
            return true;
        
        return false;
    }
    
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        
        while (i < j) {
            if (!isValid(s.charAt(i)))
                ++i;
            else if (!isValid(s.charAt(j)))
                --j;
            else {
                if (!compare(s.charAt(i), s.charAt(j)))
                    return false;
                ++i;
                --j;
            }
        }
        
        return true;
    }
}
