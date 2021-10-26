class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                int num = c - '0';
                int j = i + 1;
                while (j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                    num *= 10;
                    num += s.charAt(j) - '0';
                    ++j;
                }
                int l = j + 1;
                int count = 1;
                while (l < s.length()) {
                    if (s.charAt(l) == '[')
                        ++count;
                    else if (s.charAt(l) == ']')
                        --count;
                    if (count == 0)
                        break;
                    ++l;
                }
                String str = decodeString(s.substring(j + 1, l));
                for (int k = 0; k < num; ++k) {
                    sb.append(str);
                }
                i = l + 1;
            } else {
                sb.append(c);
                ++i;
            }
        }
        
        return sb.toString();
    }
}
