class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<String>();
        if (words == null)
            return res;
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; ++i) {
            int fre = map.getOrDefault(words[i], 0);
            map.put(words[i], fre + 1);
        }
        
        PriorityQueue<String> pq = new PriorityQueue<String>(10, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (map.get(s2) == map.get(s1))
                    return s1.compareTo(s2);
                return map.get(s2) - map.get(s1);
            }
        });
        
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < words.length; ++i) {
            if (!set.contains(words[i])) {
                pq.add(words[i]);
                set.add(words[i]);
            }
        }
        
        for (int i = 0; i < k; ++i)
            res.add(pq.poll());
        
        return res;
    }
}

============================================

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String w: words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        
        List<String> keys = new ArrayList<>();
        
        keys.addAll(map.keySet());
        
        Collections.sort(keys, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (map.get(s2) == map.get(s1))
                    return s1.compareTo(s2);

                return map.get(s2) - map.get(s1);
            }
        });
        
        return keys.subList(0, k);
    }
}
