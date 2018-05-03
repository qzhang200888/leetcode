class Solution {

    class Trie {
        public boolean isWord;
        public String word;
        public Trie[] children;
        
        public Trie() {
            word = "";
            isWord = false;
            children = new Trie[26];
            
            for (int i = 0; i < 26; ++i)
                children[i] = null;
        }
    }
    
    private void insertWord(Trie t, String word) {
        if (word == null || word.length() == 0)
            return;
        
        Trie p = t;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            
            if (p.children[c - 'a'] == null) {
                p.children[c - 'a'] = new Trie();
                p.children[c - 'a'].word = p.word + c;
            }
            
            p = p.children[c - 'a'];
            if (i == word.length() - 1)
                p.isWord = true;
        }
    }
    
    private void findWords(char[][] board, int i, int j,
                           Trie trie, Set<String> selectedWords,
                           boolean[][] visited) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return;
        
        if (visited[i][j])
            return;
        
        char c = board[i][j];
        if (trie.children[c - 'a'] != null) {
            if (trie.children[c - 'a'].isWord)
                selectedWords.add(trie.children[c - 'a'].word);
            visited[i][j] = true;
        
            findWords(board, i - 1, j, trie.children[c - 'a'], selectedWords, visited);
            findWords(board, i + 1, j, trie.children[c - 'a'], selectedWords, visited);
            findWords(board, i, j - 1, trie.children[c - 'a'], selectedWords, visited);
            findWords(board, i, j + 1, trie.children[c - 'a'], selectedWords, visited);
            visited[i][j] = false;
        }
    } 
    
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<String>();
        if (board == null || board.length == 0 ||
            board[0].length == 0 || words == null ||
            words.length == 0)
            return new ArrayList<String>();
        
        Trie trie = new Trie();
        for (String w: words)
            insertWord(trie, w);
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; ++i)
            for (int j = 0; j < board[0].length; ++j)
                visited[i][j] = false;
        
        for (int i = 0; i < board.length; ++i)
            for (int j = 0; j < board[0].length; ++j)
                findWords(board, i, j, trie, res, visited);
        
        return new ArrayList<String>(res);
    }
}
