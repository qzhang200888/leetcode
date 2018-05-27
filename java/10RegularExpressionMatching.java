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
