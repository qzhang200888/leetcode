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

// faster:

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] fuel = new int[gas.length];
        for (int i = 0; i < gas.length; ++i) {
            fuel[i] = gas[i] - cost[i];
        }
        
        int start = 0;
        int sum = 0;
        int maxStart = -1;
        int maxSum = -1;

        for (int i = 0; i < fuel.length; ++i) {                
            sum += fuel[i];
            if (sum < 0) {
                sum = 0;
                start = (i + 1) % fuel.length;
            } else if (sum > maxSum) {
                maxStart = start;
                maxSum = sum;
            }
        }
        
        if (start > 0) {
            for (int i = 0; i < start; ++i) {
                sum += fuel[i];
                if (sum < 0)
                    break;
                
                if (sum > maxSum) {
                    maxStart = start;
                    maxSum = sum;
                }
            }
        }
        
        if (maxSum < 0)
            return -1;
        
        sum = 0;
        for (int j = 0; j < fuel.length; ++j) {
            sum += fuel[(maxStart + j) % fuel.length];
            if (sum < 0) {
                return -1;
            }
        }
        
        return maxStart;
    }
}
