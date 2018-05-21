class Solution {
    boolean wordBreak(String s, Set<String> wordDict) {
        if (wordDict.contains(s))
            return true;
        
        boolean[] b = new boolean[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            if (wordDict.contains(s.substring(0, i + 1))) {
                b[i] = true;
                continue;
            }
            for (int j = 1; j <= i; ++j)
                if (wordDict.contains(s.substring(j, i + 1)) && b[j - 1]) {
                    b[i] = true;
                }
        }
        
        return b[s.length() - 1];
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<String>();
        for (String word: wordDict) {
            dict.add(word);
        }
        
        return wordBreak(s, dict);        
    }
}
