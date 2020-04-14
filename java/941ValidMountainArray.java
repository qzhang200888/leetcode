class Solution {
    public boolean validMountainArray(int[] A) {
        boolean rise = true;
        int count = 0;
        for (int i = 0; i < A.length - 1; ++i) {
            if (A[i+1] > A[i]) {
                if (!rise)
                    return false;
                ++count;
            } else if (A[i+1] < A[i]) {
                if (rise) {
                    if (count == 0)
                        return false;
                    rise = false;
                }
            } else
                return false;
        }
        
        return !rise;
    }
}
