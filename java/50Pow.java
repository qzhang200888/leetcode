class Solution {
    public double myPow(double x, int n) {
        if (x == 0)
            return 0;
        if (n == 0)
            return 1.0;
        
        if (n == Integer.MIN_VALUE)
            return 1 / myPow(x, Integer.MAX_VALUE) / x;
        
        if (n < 0)
            return 1 / myPow(x, -n);
        
        double d = myPow(x, n / 2);
        
        if (n % 2 == 0) {
            return d * d;
        }
        
        return d * d * x;
    }
}
