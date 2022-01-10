class Solution {
    void addVisits(int num, String domain, Map<String, Integer> map) {
        map.put(domain, map.getOrDefault(domain, 0) + num);
        int idx = domain.indexOf(".");
        if (idx > 0)
            addVisits(num, domain.substring(idx + 1), map);
    }

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String str: cpdomains) {
            String[] strs = str.split("\\s+");
            int num = Integer.parseInt(strs[0]);
            addVisits(num, strs[1], map);
        }
        
        List<String> res = new ArrayList<>();
        for (String key: map.keySet()) {
            res.add("" + map.get(key) + " " + key);
        }
        
        return res;
    }
}
