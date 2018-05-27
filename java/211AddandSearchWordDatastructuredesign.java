class WordDictionary {
    class Trie {
        Trie[] children;
        boolean isWord;
        
        public Trie() {
            children = new Trie[26];
            isWord = false;
        }
        
        boolean search(char[] chars, int pos) {
            if (pos >= chars.length)
                return isWord;
            
            char c = chars[pos];
            if (c != '.' && children[c - 'a'] != null)
                return children[chars[pos] - 'a'].search(chars, pos + 1);
            if (c == '.')
                for (Trie child: children)
                    if (child != null && child.search(chars, pos + 1))
                        return true;
            
            return false;
        }
        
        public boolean search(String s) {
            return search(s.toCharArray(), 0);
        }
        
        void addWord(char[] chars, int pos) {
            if (pos >= chars.length) {
                isWord = true;
                return;
            }
            if (children[chars[pos] - 'a'] == null)
                children[chars[pos] - 'a'] = new Trie();
            
            children[chars[pos] - 'a'].addWord(chars, pos + 1);           
        }
        
        public void addWord(String s) {
            addWord(s.toCharArray(), 0);
        }
    }
    
    Trie trie;
    /** Initialize your data structure here. */
    public WordDictionary() {
        trie = new Trie();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        trie.addWord(word);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return trie.search(word);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
