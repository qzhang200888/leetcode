class Solution {
    public int numberOfSteps(int num) {
        int step = 0;
        while (num != 0) {
            ++step;
            if (num % 2 == 0)
                num /= 2;
            else --num;
        }
        
        return step;
    }
}
