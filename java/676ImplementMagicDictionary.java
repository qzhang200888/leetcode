class MagicDictionary {
    List<String> words;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        words = new LinkedList<>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        words.clear();
        for (String w: dict) {
            words.add(w);
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        for (String w: words) {
            if (w.length() != word.length())
                continue;
            int diff = 0;
            for (int i = 0; i < w.length(); ++i) {
                if (w.charAt(i) != word.charAt(i))
                    ++diff;
                if (diff > 1)
                    break;
            }
            
            if (diff == 1)
                return true;
        }
        
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */

// faster for search
class MagicDictionary {
    Set<String> words;
    Map<String, Integer> map;
    
    /** Initialize your data structure here. */
    public MagicDictionary() {
        words = new HashSet<>();
        map = new HashMap<>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        words.clear();
        map.clear();
        for (String w: dict) {
            words.add(w);
            char[] chars = w.toCharArray();
            for (int i = 0; i < chars.length; ++i) {
                char c = chars[i];
                chars[i] = '*';
                
                String newWord = new String(chars);
                map.put(newWord, map.getOrDefault(newWord, 0) + 1);
                
                chars[i] = c;
            }
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        for (int i = 0; i < word.length(); ++i) {
            String newWord = word.substring(0, i) + "*" + word.substring(i + 1);
            int count = map.getOrDefault(newWord, 0);
            if (count > 1 || (count == 1 && !words.contains(word)))
                return true;
        }
        
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */
