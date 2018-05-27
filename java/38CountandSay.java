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
