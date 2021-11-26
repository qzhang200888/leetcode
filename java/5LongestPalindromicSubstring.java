class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0)
            return "";
        boolean[][] db = new boolean[s.length()][s.length()];
        
        char[] chars = s.toCharArray();
        int start = 0, end = 1;
        for (int i = 0; i < db.length; ++i) {
            db[i][i] = true;
        }
        for (int i = 0; i < db.length - 1; ++i) {
            db[i][i+1] = chars[i] == chars[i+1];
            if (db[i][i+1] && end - start < 2) {
                start = i;
                end = i + 2;
            }
        }
        
        for (int diff = 2; diff < db.length; ++diff) {
            for (int i = 0; i < db.length - diff; ++i) {
                db[i][i+diff] = db[i+1][i+diff-1] && chars[i] == chars[i + diff];
                if (db[i][i+diff] && end - start < diff + 1) {
                    start = i;
                    end = i + diff + 1;
                }
            }
        }
        
        return s.substring(start, end);
    }
}
