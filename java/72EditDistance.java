
class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dist = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i <= word2.length(); ++i)
            dist[0][i] = i;
        for (int i = 1; i <= word1.length(); ++i)
            dist[i][0] = i;
        
        for (int i = 1; i <= word1.length(); ++i) {
            for (int j = 1; j <= word2.length(); ++j) {
                int op = dist[i-1][j] + 1;
                op = Math.min(op, dist[i][j - 1] + 1);
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    op = Math.min(op, dist[i - 1][j - 1]);
                } else {
                    op = Math.min(op, dist[i - 1][j - 1] + 1);
                }
                
                dist[i][j] = op;
            }
        }
        
        return dist[word1.length()][word2.length()];
    }
}

======================================
class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null)
            return 0;
        if (word1 == null)
            return word2.length();
        if (word2 == null)
            return word1.length();
        
        int[][] dist = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i <= word1.length(); ++i)
            dist[i][0] = i;
        for (int j = 1; j <= word2.length(); ++j)
            dist[0][j] = j;

        for (int i = 1; i <= word1.length(); ++i)
            for (int j = 1; j <= word2.length(); ++j) {
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    dist[i][j] = dist[i-1][j-1];
                else {
                    dist[i][j] = Math.min(dist[i-1][j], dist[i][j-1]);
                    dist[i][j] = Math.min(dist[i-1][j-1], dist[i][j]);
                    ++dist[i][j];
                }
            }
        
        return dist[word1.length()][word2.length()];
    }
}
