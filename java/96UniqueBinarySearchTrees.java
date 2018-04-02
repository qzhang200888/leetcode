class Solution {
    public int numTrees(int n) {
        if (n <= 0) return 0;
        if (n <= 1) return 1;
        
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= n; ++i) {
            arr[i] = 0;
            for (int j = 1; j <= i; ++j)
                arr[i] += arr[j - 1] * arr[i - j];
        }
        
        return arr[n];
    }
}
