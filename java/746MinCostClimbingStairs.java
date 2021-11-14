class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 0)
            return 0;
        int[] minCost = new int[cost.length];
        minCost[cost.length - 1] = cost[cost.length - 1];
        if (cost.length == 0)
            return minCost[0];
        
        minCost[cost.length - 2] = Math.min(cost[cost.length - 2], cost[cost.length - 1] + cost[cost.length - 2]);
        for (int i = cost.length - 3; i >= 0; --i) {
            minCost[i] = cost[i] + Math.min(minCost[i+1], minCost[i+2]);
        }
        
        return Math.min(minCost[0], minCost[1]);
    }
}
