class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; ++i) {
            int g = gas[i] - cost[i];
            if (g < 0)
                continue;
            boolean pass = true;
            for (int j = 1; j < gas.length; ++j) {
                g += gas[(i + j) % gas.length] - cost[(i + j) % gas.length];
                if (g < 0) {
                    pass = false;
                    break;
                }
            }
            
            if (pass)
                return i;
        }
        
        return -1;
    }
}
