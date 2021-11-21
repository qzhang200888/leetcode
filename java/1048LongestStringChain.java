class Solution {
    int iterate(Map<String, List<String>> graph, String cur, Set<String> visited, Map<String, Integer> map) {
        if (!graph.containsKey(cur))
            return 1;
        if (map.containsKey(cur))
            return map.get(cur);
        
        visited.add(cur);
        List<String> neighbors = graph.get(cur);
        
        int max = 1;
        for (String nei: neighbors) {
            if (visited.contains(nei))
                continue;
            int len = iterate(graph, nei, visited, map);
            if (len + 1 > max)
                max = len + 1;
        }
        
        visited.remove(cur);
        map.put(cur, max);
        return max;
    }
    
    public int longestStrChain(String[] words) {
        Set<String> set = new HashSet<>();
        for (String w: words)
            set.add(w);
        
        Map<String, List<String>> graph = new HashMap<>();
        Set<String> nonHead = new HashSet<>();
        for (String w: words) {
            if (!graph.containsKey(w))
                graph.put(w, new ArrayList<>());
            for (int i = 0; i < w.length(); ++i) {
                String s = w.substring(0, i) + w.substring(i + 1);
                if (set.contains(s)) {
                    graph.get(w).add(s);
                    nonHead.add(s);
                }
            }
        }
        
        
        int max = 0;
        Set<String> visited = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        for (String w: words) {
            if (nonHead.contains(w))
                continue;
            int len = iterate(graph, w, visited, map);
            if (max < len)
                max = len;
        }
        
        return max;
    }
}
