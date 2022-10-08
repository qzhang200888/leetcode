class Solution {
    public int minSteps(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            map1.put(c, map1.getOrDefault(c, 0) + 1);
            c = t.charAt(i);
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        int step = 0;
        for (char key: map1.keySet()) {
            int s1 = map1.get(key);
            int s2 = map2.getOrDefault(key, 0);
            if (s1 > s2) {
                step += s1 - s2;
            }
        }

        return step;
    }
}
