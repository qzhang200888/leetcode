class Solution {
    public int calculate(String s) {
        if (s == null)
            return 0;
        int res = 0;
        int mult = 0;
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == ' ') {
                ++i;
                continue;
            }
            
            int operator = 0;
            if (c == '-')
                operator = 1;
            else if (c == '*')
                operator = 2;
            else if (c == '/')
                operator = 3;
            
            while (i < s.length() && (s.charAt(i) < '0' || s.charAt(i) > '9'))
                ++i;
            
            int j = i + 1;
            while (j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9' )
                ++j;
            
            int val = Integer.parseInt(s.substring(i, j));

            i = j;
            switch (operator) {
                case 0: res += val;
                    mult = val;
                    break;
                case 1: res -= val;
                    mult = -val;
                    break;
                case 2: res += -mult + mult * val;
                    mult *= val;
                    break;
                case 3: res += -mult + mult / val;
                    mult /= val;
                    break;
                default:
            }
        }
        
        return res;
    }
}
