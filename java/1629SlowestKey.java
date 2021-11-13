class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        if (releaseTimes == null || releaseTimes.length == 0)
            return '\0';
        
        List<Character> lst = new ArrayList<>();
        lst.add(keysPressed.charAt(0));
        int max = releaseTimes[0];
        for (int i = 1; i < releaseTimes.length; ++i) {
            int dur = releaseTimes[i] - releaseTimes[i - 1];
            if (dur > max) {
                max = dur;
                lst.clear();
                lst.add(keysPressed.charAt(i));
            } else if (dur == max) {
                lst.add(keysPressed.charAt(i));
            }
        }
        
        char c = lst.get(0);
        for (int i = 1; i < lst.size(); ++i) {
            if (lst.get(i) > c)
                c = lst.get(i);
        }
        
        return c;
    }
}
