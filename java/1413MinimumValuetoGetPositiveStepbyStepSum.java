class Solution {
    public int minStartValue(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i: nums) {
            sum += i;
            if (sum < min)
                min = sum;
        }
        
        if (min >= 0)
            return 1;
        return -min + 1;
    }
}
