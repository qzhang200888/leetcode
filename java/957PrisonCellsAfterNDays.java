class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        int[] cur = cells;
        int[] next = new int[cells.length];
        Set<String> st = new HashSet<>();
        
        while (n > 0) {
            --n;
            for (int i = 0; i < cur.length; ++i) {
                if (i == 0 || i == cur.length - 1) {
                    next[i] = 0;
                    continue;
                }
                
                if (cur[i-1] == cur[i+1])
                    next[i] = 1;
                else next[i] = 0;
            }
            
            int[] tmp = next;
            next = cur;
            cur = tmp;
            
            String key = Arrays.toString(cur);
            if (st.contains(key))
                n %= st.size();
            else {
                st.add(key);
            }
        }
        
        return cur;
    }
}
