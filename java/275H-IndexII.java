class Solution {
    public int hIndex(int[] citations) {
        for (int i = citations.length - 1; i >= 0; --i) {
            int h = citations.length - i;
            if (citations[i] >= h && (i == 0 || citations[i - 1] <= h))
                return h;
        }

        return 0;
    }
}
