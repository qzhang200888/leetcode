class Solution {
    boolean isMatch(char[] str, int i, char[] patern, int j, char prev) {
        if (i >= str.length && j >= patern.length)
            return true;
        if (i >= str.length) {
            while (j < patern.length) {
                if (patern[j] != '*' && (j + 1 >= patern.length || patern[j + 1] != '*'))
                    return false;
                ++j;
            }

            return true;
        }

        if (j >= patern.length)
            return false;

        if (str[i] == patern[j] || patern[j] == '.')
            if (isMatch(str, i + 1, patern, j + 1, patern[j]))
                return true;

        if (patern[j] == '*') {
            if (str[i] == prev || prev == '.')
                return isMatch(str, i + 1, patern, j, prev) || isMatch(str, i, patern, j + 1, prev);
            return isMatch(str, i, patern, j + 1, prev);
        }

        if (j < patern.length - 1 && patern[j + 1] == '*')
            return isMatch(str, i, patern, j + 2, '\0');

        return false;
    }

    public boolean isMatch(String s, String p) {
        if (s == null && p == null)
            return true;
        if (s == null)
            return false;

        return isMatch(s.toCharArray(), 0, p.toCharArray(), 0, '\0');
    } 
}

// faster

class Solution {
    public boolean isMatch(String s, String p) {
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        
        int m = ss.length, n = pp.length;
        boolean[][] dp = new boolean[m+1][n+1];
        dp[m][n] = true;
        for (int j = n-1; j > 0; j--) {
            if (pp[j] != '*') break;
            j--;
            dp[m][j] = true;
        }
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (pp[j] == '*') {
                    j--;
                    if (dp[i][j+2]) {
                        dp[i][j] = true;
                    } else if (pp[j] == '.' || pp[j] == ss[i]) {
                        dp[i][j] = dp[i+1][j];
                    }
                } else if (pp[j] == '.' || pp[j] == ss[i]) {
                    dp[i][j] = dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    } 
}
