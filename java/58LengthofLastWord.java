class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null)
            return 0;
        int start = s.length() - 1;
        while (start >= 0 && s.charAt(start) == ' ')
            --start;
        
        if (start < 0)
            return 0;
        
        int end = start;
        while (start >= 0 && s.charAt(start) != ' ')
            --start;
        
        return end - start;
    }
}
