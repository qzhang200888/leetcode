class Solution {
    public boolean isMatch(String s, String p) {        
        boolean[][] res = new boolean[s.length() + 1][p.length() + 1];
        
        for (int i = s.length(); i >= 0; --i) {
            for (int j = p.length(); j >= 0; --j) {
                if (i == s.length() && j == p.length()) {
                    res[i][j] = true;
                } else if (j == p.length()) {
                    res[i][j] = false;
                } else if (i == s.length()) {
                    char c = p.charAt(j);
                    if (c != '*')
                        res[i][j] = false;
                    else res[i][j] = res[i][j + 1];
                } else {
                    char c1 = s.charAt(i);
                    char c2 = p.charAt(j);
                
                    if (c1 == c2 || c2 == '?') {
                        res[i][j] = res[i+1][j+1];
                    } else if (c2 != '*') {
                        res[i][j] = false;
                    } else {
                        res[i][j] = res[i + 1][j] || res[i][j + 1];
                    }
                }
            }
        }

        return res[0][0];
    }
}
