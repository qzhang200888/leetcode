class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount == 0)
            return 0;
        
        int[] changes = new int[amount + 1];
        for (int i = 1; i <= amount; ++i)
            changes[i] = Integer.MAX_VALUE;
        
        Arrays.sort(coins);
        for (int c: coins)
            for (int i = 1; i <= amount; ++i) {
                if (i >= c && changes[i - c] != Integer.MAX_VALUE) {
                    int newChange = changes[i - c] + 1;
                    if (newChange < changes[i])
                        changes[i] = newChange;
                }
            }
        
        if (changes[amount] == Integer.MAX_VALUE)
            return -1;
        
        return changes[amount];
    }
}
