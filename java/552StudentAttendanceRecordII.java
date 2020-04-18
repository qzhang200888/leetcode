class Solution {
    void checkRecord(int n, int pos, int countA, int countL, long[] res) {   
        if (pos > n) {
            res[0] += 1;
            return;
        }
        
        if (countA == 0)
            checkRecord(n, pos + 1, countA + 1, countL, res);
        
        if (countL < 2)
            checkRecord(n, pos + 1, countA, countL + 1, res);
        
        checkRecord(n, pos + 1, countA, countL, res);        
    }
    
    public int checkRecord(int n) {
        long[] res = new long[1];
        checkRecord(n, 1, 0, 0, res);
        
        return (int)(res[0] % 1000000007l);
    }
}
