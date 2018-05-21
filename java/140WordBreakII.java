class Solution {
    List<String> wordBreak(String s, Set<String> dict) {
        boolean[] b = new boolean[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            if (dict.contains(s.substring(0, i + 1))) {
                b[i] = true;
                continue;
            }
            for (int j = 1; j <= i; ++j)
                if (dict.contains(s.substring(j, i + 1)) && b[j - 1]) {
                    b[i] = true;
                }
        }
        
        if (!b[s.length() - 1])
            return new ArrayList<String>();
        
        List<List<String>> res = new ArrayList<List<String>>();
        for (int i = 0; i < s.length(); ++i) {
            List<String> lst = new ArrayList<String>();
            for (int j = 1; j <= i; ++j) {
                String word = s.substring(j, i + 1);
                if (dict.contains(word)) {
                    for (String w: res.get(j-1)) {
                        lst.add(w + " " + s.substring(j, i + 1));
                    }
                }
            }
            
            if (dict.contains(s.substring(0, i + 1)))
                lst.add(s.substring(0, i + 1));
            res.add(lst);
        }
                
        return res.get(s.length() - 1);
    }
        
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<String>();
        for (String word: wordDict) {
            dict.add(word);
        }
        
        return wordBreak(s, dict);
    }
}
