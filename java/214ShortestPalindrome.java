class Solution {
    boolean isPalindrome(char[] arr, int end) {
        int start = 0;
        while (start < end) {
            if (arr[start] != arr[end])
                return false;
            ++start;
            --end;
        }
            
        return true;
    }
    
    String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
    
    public String shortestPalindrome(String s) {
        if (s == null || s.equals(""))
            return s;
        
        char[] arr = s.toCharArray();
        int j = arr.length - 1;
        while (j >= 1) {
            if (isPalindrome(arr, j))
                break;
            --j;
        }
        
        return reverse(s.substring(j + 1)) + s;
    }
}
