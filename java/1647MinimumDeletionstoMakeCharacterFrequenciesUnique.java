class Solution {
    public int minDeletions(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            ++arr[s.charAt(i) - 'a'];
        }
        
        boolean[] set = new boolean[s.length() + 1];
        int count = 0;
        for (int i = 0; i < 26; ++i) {
            int cnt = arr[i];
            while (cnt > 0 && set[cnt]) {
                --cnt;
                ++count;
            }
            
            if (cnt > 0)
                set[cnt] = true;
        }
        
        return count;
    }
}
