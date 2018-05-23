class Solution {
    public int numDecodings(String s) {
        if (s == null && s.length() == 0)
            return 0;
        
        int[] res = new int[s.length() + 1];
        res[0] = 1;
        for (int i = 1; i <= s.length(); ++i) {
            char cc = s.charAt(i - 1);
            if (cc > '0')
                res[i] = res[i - 1];
            if (i >= 2) {
                char c = s.charAt(i - 2);
                if (c == '1' || (c == '2' && cc <= '6'))
                    res[i] += res[i - 2];
            }
        }
        
        return res[s.length()];
    }
}
