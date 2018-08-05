class Solution {
    public int leastInterval(char[] tasks, int n) {
        Integer[] ar = new Integer[26];
        for (int i = 0; i < 26; ++i)
            ar[i] = new Integer(0);
        
        for (char t: tasks) {
            ++ar[t - 'A'];
        }
        
        Arrays.sort(ar, Collections.reverseOrder());
        int fre = ar[0];
        int idle = (fre - 1) * n;
        for (int i = 1; i < 26; ++i) {
            if (ar[i] == null)
                break;
            idle -= Math.min(ar[i], fre - 1);
        }
        
        if (idle > 0)
            return tasks.length + idle;
        
        return tasks.length;
    }
}
