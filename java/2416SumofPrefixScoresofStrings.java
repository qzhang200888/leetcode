class Solution {
    class Node {
        public int count;
        public Node[] children;
        
        public Node() {
            children = new Node[26];
        }
    }
    
    void insert(Node n, char[] word, int pos) {
        if (pos == word.length) {
            return;
        }
        
        char c = word[pos];
        int idx = c - 'a';
        if (n.children[idx] == null) {
            n.children[idx] = new Node();
        }
        
        n.children[idx].count += 1;
        insert(n.children[idx], word, pos + 1);
    }
    
    int countPrefix(Node n, char[] chars, int pos) {
        if (n == null) {
            return 0;
        }
        int count = n.count;
        
        if (pos == chars.length) {
            return count;
        }
        
        char c = chars[pos];
        int idx = c - 'a';
        count += countPrefix(n.children[idx], chars, pos + 1);
        
        return count;
    }
    
    public int[] sumPrefixScores(String[] words) {
        Node root = new Node();
        for (String w: words) {
            char[] chars = w.toCharArray();
            insert(root, chars, 0);
        }

        int[] res = new int[words.length];
        for (int i = 0; i < words.length; ++i) {
            char[] chars = words[i].toCharArray();
            res[i] = countPrefix(root, chars, 0);
        }
        return res;
    }
}
