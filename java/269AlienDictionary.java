public class Solution {
    
    String sorted(boolean[] charList, List<Integer>[] graphs) {
        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();
        
        for (int i = charList.length - 1; i >= 0; --i) {
            if (visited[i])
                continue;
                
            boolean[] path = new boolean[26];
            if (!sort(charList, (char)('a' + i), graphs, visited, path, stack))
                return "";
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        return sb.toString();
    }
    
    boolean sort(boolean[] charList, char c, List<Integer>[] graphs, boolean[] visited, boolean[] path, Stack<Character> stack) {
        if (!charList[c - 'a'])
            return true;
            
        if (path[c - 'a']) {
            System.out.println("c = " + c);
            return false;
        }
        path[c - 'a'] = true;
        
        if (visited[c - 'a'])
            return true;
        visited[c - 'a'] = true;
        if (graphs[c - 'a'] != null) {
            for (int neighbor: graphs[c - 'a']) {
                if (!sort(charList, (char)('a' + neighbor), graphs, visited, path, stack))
                    return false;
            }
        }
        
        stack.push(c);
        
        path[c - 'a'] = false;
        return true;
    }
    
    /**
     * @param words: a list of words
     * @return: a string which is correct order
     */
    public String alienOrder(String[] words) {
        if (words == null)
            return null;
            
        List<Integer>[] graphs = new List[26];
        boolean[] charList = new boolean[26];
        
        for (int i = 0; i < words.length - 1; ++i) {
            int len = Math.min(words[i].length(), words[i+1].length());
            int j = 0;
            for ( ; j < len; ++j) {
                charList[words[i].charAt(j) - 'a'] = true;
                if (words[i].charAt(j) == words[i + 1].charAt(j)) {
                    continue;
                }
                
                charList[words[i + 1].charAt(j) - 'a'] = true;
                if (graphs[words[i].charAt(j) - 'a'] == null) {
                    graphs[words[i].charAt(j) - 'a'] = new LinkedList<>();
                }
                
                graphs[words[i].charAt(j) - 'a'].add(words[i + 1].charAt(j) - 'a');
                break;
            }
            
            int index = j + 1;
            while (index < words[i].length()) {
                charList[words[i].charAt(index) - 'a'] = true;
                ++index;
            }
            
            index = j + 1;
            while (j < words[i + 1].length()) {
                charList[words[i + 1].charAt(j) - 'a'] = true;
                ++j;
            }
        }
        
        return sorted(charList, graphs);
    }
}
