class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (beginWord == null || endWord == null)
            return res;
        
        Set<String> dict = new HashSet<String>(wordList);
        if (!dict.contains(endWord))
            return res;
        
        Map<String, List<List<String>>> visited = new HashMap<String, List<List<String>>>();
        
        Queue<String> q = new LinkedList<String>();
        q.add(beginWord);
        visited.put(beginWord, Arrays.asList(Arrays.asList(beginWord)));
        
        while (!q.isEmpty()) {
            int size = q.size();
            Map<String, List<List<String>>> temp = new HashMap<String, List<List<String>>>();
            for (int i = 0; i < size; ++i) {
                String word = q.poll();
                char[] chars= word.toCharArray();
                List<List<String>> lsts = visited.get(word);
                for (int j = 0; j < chars.length; ++j) {
                    char origin = chars[j];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        if (c == origin)
                            continue;
                        chars[j] = c;
                        
                        String newWord = new String(chars);
                        if (dict.contains(newWord) && !visited.containsKey(newWord)) {
                            if (newWord.equals(endWord)) {
                                for (List<String> l: lsts) {
                                    List<String> nl = new ArrayList<String>(l);
                                    nl.add(newWord);
                                    res.add(nl);
                                }
                                continue;
                            }

                            if (!temp.containsKey(newWord))
                                q.add(newWord);
                            
                            List<List<String>> newLsts = new ArrayList<List<String>>();
                            for (List<String> l: lsts) {
                                List<String> nl = new ArrayList<String>(l);
                                nl.add(newWord);
                                newLsts.add(nl);
                            }
                            
                            if (!temp.containsKey(newWord))
                                temp.put(newWord, newLsts);
                            else {
                                List<List<String>> nls = temp.get(newWord);
                                nls.addAll(newLsts);
                                temp.put(newWord, nls);
                            }
                        }
                    }
                    
                    chars[j] = origin;
                }
            }
            
            for (String key: temp.keySet()) {
                visited.put(key, temp.get(key));
            }
        }
        
        int shortest = Integer.MAX_VALUE;
        for (List<String> lst: res) {
            if (lst.size() < shortest)
                shortest = lst.size();
        }
        
        List<List<String>> output = new ArrayList<List<String>>();
        for (List<String> lst: res) {
            if (lst.size() == shortest)
                output.add(lst);
        }
        
        return output;
    }
}
