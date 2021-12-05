class Solution {
    int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<String, Integer> map) {
        String key = needs.toString();
        if (map.containsKey(key))
            return map.get(key);

        int cost = 0;
        for (int i = 0; i < needs.size(); ++i) {
            cost += price.get(i) * needs.get(i);
        }
        
        for (List<Integer> sp: special) {
            List<Integer> newNeeds = newNeeds(needs, sp);
            if (newNeeds != null) {
                cost = Math.min(cost, sp.get(sp.size() - 1) + shoppingOffers(price, special, newNeeds, map));
            }
        }
        
        map.put(key, cost);
        
        return cost;
    }
    
    List<Integer> newNeeds(List<Integer> needs, List<Integer> sp) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < needs.size(); ++i) {
            if (needs.get(i) < sp.get(i))
                return null;
            res.add(needs.get(i) - sp.get(i));
        }
        
        return res;
    }
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map<String, Integer> map = new HashMap<>();
        return shoppingOffers(price, special, needs, map);
    }
}
