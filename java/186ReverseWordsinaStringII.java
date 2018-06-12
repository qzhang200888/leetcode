public class Solution {
    void reverse(char[] str, int s, int e) {
        while (s < e) {
            char c = str[s];
            str[s] = str[e];
            str[e] = c;
            ++s;
            --e;
        }        
    }
    
    void reverse(char[] str) {
        reverse(str, 0, str.length - 1);
    }
    
    /**
     * @param str: a string
     * @return: return a string
     */
    public char[] reverseWords(char[] str) {
        if (str == null)
            return null;
            
        reverse(str);
        
        int s = 0;
        while (s < str.length) {
            int e = s;
            while (e < str.length && str[e] != ' ')
                ++e;
            
            if (str[e - 1] != ' ')    
                reverse(str, s, e - 1);
            
            s = e;
            while (s < str.length && str[s] == ' ')
                ++s;
        }
        
        return str;
    }
}
