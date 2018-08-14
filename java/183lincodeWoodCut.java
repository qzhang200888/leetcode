public class Solution {
    
    int cutPieces(int[] L, int len) {
        int numPieces = 0;
        for (int i = 0; i < L.length; ++i)
            numPieces += L[i] / len;
            
        return numPieces;
    }
    /**
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] L, int k) {
        if (L == null || L.length == 0)
            return 0;
            
        int max = 0;
        long sum = 0;
        for (int i = 0; i < L.length; ++i) {
            if (L[i] > max)
                max = L[i];
            sum += L[i];
        }
        
        if (sum < k)
            return 0;
            
        int lo = 1, hi = max;
        
        while (lo < hi - 1) {
            int mid = lo + (hi - lo) / 2;
            if (cutPieces(L, mid) >= k)
                lo = mid;
            else hi = mid - 1;
        }
        
        if (hi > lo && cutPieces(L, hi) >= k)
            return hi;
            
        return lo;
    }
}
