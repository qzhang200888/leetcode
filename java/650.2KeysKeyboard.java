class Solution {
    public int minSteps(int n) {
        if (n <= 1)
            return 0;
        
        int[] steps = new int[n+1];
        steps[0] = 0;
        steps[1] = 0;
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i / 2; ++j) {
                if (i % j == 0) {
                    int k = steps[j] + i / j;
                    
                    if (steps[i] == 0)
                        steps[i] = k;
                    else if (steps[i] > k)
                        steps[i] = k;
                }
            }
        }
        
        return steps[n];
    }
}
