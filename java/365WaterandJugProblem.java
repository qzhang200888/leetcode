class Solution {
    int gcd(int a, int b) {
        while (b > 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        
        return a;
    }
    
    public boolean canMeasureWater(int x, int y, int z) {
        if (z > x + y)
            return false;
        if (z == x || z == y)
            return true;
        
        return z % gcd(x, y) == 0;
    }
}
