class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost) {
        if (cost.size() <= 1)
            return 0;
        
        vector<int> totalCost(cost.size() + 1, 0);
        totalCost[0] = 0;
        totalCost[1] = 0;
        
        for (int i = 2; i <= cost.size(); ++i) {
            totalCost[i] = totalCost[i-1] + cost[i-1];
            if (totalCost[i] > totalCost[i-2] + cost[i-2])
                totalCost[i] = totalCost[i-2] + cost[i-2];
        }
        
        return totalCost[cost.size()];
    }
};
