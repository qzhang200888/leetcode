class Solution {        
    void fly(String s, Map<String, List<String>> map, LinkedList<String> res) {
        if (map.containsKey(s)) {
            List<String> lst = map.get(s);
            while (lst.size() > 0) {
                String dest = lst.get(lst.size() - 1);
                lst.remove(lst.size() - 1);
                fly(dest, map, res);
            }
        }
        
        res.addFirst(s);
    }
    
    public List<String> findItinerary(String[][] tickets) {
        if (tickets == null)
            return null;
        
        Map<String, List<String>> map = new HashMap<>();
        for (String[] trip: tickets) {
            List<String> lst = map.get(trip[0]);
            if (lst == null) {
                lst = new ArrayList<>();
                map.put(trip[0], lst);
            }
            lst.add(trip[1]);
        }
        
        for (String key: map.keySet()) {
            List<String> lst = map.get(key);
            Collections.sort(lst, Collections.reverseOrder());
        }

        LinkedList<String> res = new LinkedList<>();
        fly("JFK", map, res);
        
        return res;
    }
}
