
class Solution {
    public String countAndSay(int n) {
        if (n < 1)
            return "";
        if (n == 1)
            return "1";
        String s = countAndSay(n - 1);
        
        StringBuilder sb = new StringBuilder();
        int count = 0;
        char c = '\0';
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (i == 0) {
                count = 1;
                c = ch;
                continue;
            }
            
            if (c != ch) {
                sb.append(count);
                sb.append(c);
                c = ch;
                count = 1;
                continue;
            }
            
            ++count;
        }
        
        sb.append(count);
        sb.append(c);
        
        return sb.toString();
    }
}

==================================================

class Solution {  
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; ++i) {
            int j = 0;
            int count = 1;
            
            String newS = "";
            char[] chars = s.toCharArray(); 
            while (j < chars.length) {
                if ((j + 1) >= chars.length || chars[j] != chars[j + 1]) {
                    newS = newS + (char)('0' + count) + chars[j];
                    count = 0;
                }
                
                ++count;
                ++j;
            }
            
            s = newS;
        }
        
        return s;
    }
}
