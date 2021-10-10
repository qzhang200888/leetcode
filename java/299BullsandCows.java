class Solution {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> map = new HashMap<>();
        int bulls = 0;
        boolean[] bullPos = new boolean[guess.length()];
        
        for (int i = 0; i < secret.length(); ++i) {
            char c = secret.charAt(i);
            if (c == guess.charAt(i)) {
                ++bulls;
                bullPos[i] = true;
            } else {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        
        int cows = 0;
        for (int i = 0; i < secret.length(); ++i) {
            if (bullPos[i])
                continue;

            char c = guess.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                ++cows;
                if (map.get(c) == 0)
                    map.remove(c);
            }
        }
        
        return "" + bulls + "A" + cows + "B";
    }
}
