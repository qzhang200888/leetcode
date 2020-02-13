qclass Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> lst = new ArrayList<>();
        int[] common = null;
        
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i][1] < B[j][0]) {
                if (common != null) {
                    if (common[1] < A[i][0]) {
                        lst.add(common);
                        common = null;
                    } else {
                        common[1] = Math.min(common[1], A[i][1]);
                    }
                }
                ++i;
            } else if (A[i][0] > B[j][1]) {
                if (common != null) {
                    if (common[1] < B[j][0]) {
                        lst.add(common);
                        common = null;
                    } else {
                        common[1] = Math.min(common[1], B[j][1]);
                    }
                }

                ++j;
            } else {
                int[] m = new int[2];

                m[0] = Math.max(A[i][0], B[j][0]);
                m[1] = Math.min(A[i][1], B[j][1]);
                
                if (common == null)
                    common = m;
                else if (common[1] < m[0]) {
                    lst.add(common);
                    common = m;
                } else {
                    common[0] = Math.max(common[0], m[0]);
                    common[1] = Math.min(common[1], m[1]);
                }
                
                if (A[i][1] < B[j][1])
                    ++i;
                else
                    ++j;
            } 
        }
        
        if (common != null)
            lst.add(common);
        
        
        int[][] res = new int[lst.size()][];
        i = 0;
        for (int[] interval: lst) {
            res[i] = interval;
            ++i;
        }
        
        return res;
    }
}
