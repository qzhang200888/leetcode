class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        Object[] arr = new Object[n];
        for (int[] rd: roads) {
            if (arr[rd[0]] == null)
                arr[rd[0]] = new HashSet<Integer>();
            if (arr[rd[1]] == null)
                arr[rd[1]] = new HashSet<Integer>();
            ((HashSet<Integer>)arr[rd[0]]).add(rd[1]);
            ((HashSet<Integer>)arr[rd[1]]).add(rd[0]);
        }
        
        int max = 0;
        for (int i = 0; i < n; ++i) {
            if (arr[i] == null)
                continue;
            for (int j = i + 1; j < n; ++j) {
                if (arr[j] == null)
                    continue;
                int count = ((HashSet<Integer>)arr[i]).size() + ((HashSet<Integer>)arr[j]).size();
                if (((HashSet<Integer>)arr[i]).contains(j))
                    --count;
                if (count > max)
                    max = count;
            }
        }
        
        return max;
    }
}
