class Solution {
    private boolean pyramidTransition(List<Set<Character>> sets, Map<String, List<Character>> map) {
        if (sets.size() == 1)
            return true;
        
        List<Set<Character>> newSets = new ArrayList<Set<Character>>();
        for (int i = 0; i< sets.size() - 1; ++i) {
            Set<Character> s = new HashSet<Character>();
            for (char c1: sets.get(i))
                for (char c2: sets.get(i + 1)) {
                    String key = "" + c1 + c2;
                    if (!map.containsKey(key))
                        continue;
                    for (char c: map.get(key))
                        s.add(c);
                }
            
            if (s.size() == 0)
                return false;
            
            newSets.add(s);
        }
        
        return pyramidTransition(newSets, map);
    }
    
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        if (bottom == null || bottom.length() == 1)
            return true;
        if (allowed.size() == 0)
            return false;
        
        List<Set<Character>> sets = new ArrayList<Set<Character>>();
        for (int i = 0; i < bottom.length(); ++i) {
            Set<Character> s = new HashSet<Character>();
            s.add(bottom.charAt(i));
            sets.add(s);
        }
        
        Map<String, List<Character>> map = new HashMap<String, List<Character>>();
        for (String str: allowed) {
            String key = str.substring(0, 2);
            char c = str.charAt(2);
            List<Character> lst = map.getOrDefault(key, new ArrayList<Character>());
            lst.add(c);
            map.put(key, lst);
        }
        
        return pyramidTransition(sets, map);
    }
}
