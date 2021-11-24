class TimeMap {
    Map<String, TreeMap<Integer, String>> map;
    
    public TimeMap() {
        map = new HashMap<>();    
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new TreeMap<>());
        }
        
        //Map<Integer, String> mp = map.get(key);
        TreeMap<Integer, String> mp = map.get(key);
        mp.put(timestamp, value);
        map.put(key, mp);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        TreeMap<Integer, String> mp = map.get(key);
        Integer time = mp.floorKey(timestamp);
        if (time == null)
            return "";
        
        return map.get(key).get(time);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
