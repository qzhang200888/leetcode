// straight forward
class Solution {
    public int[] sumZero(int n) {
        if (n <= 0)
            return new int[] {};

        if (n == 1)
            return new int[] {0};
        if (n == 2)
            return new int[]{1, -1};
                           
        int[] sum = sumZero(n - 2);
            
        int[] res = new int[n];
        res[0] = n / 2;
        res[n - 1] = - n /2;
            
        for (int i = 0; i < n - 2; ++i) {
            res[i + 1] = sum[i];
        }
        
        return res;
    }
}

//faster:

class Solution {
    public int[] sumZero(int n) {
        if (n <= 0)
            return new int[] {};

        if (n == 1)
            return new int[] {0};
        if (n == 2)
            return new int[]{1, -1};

        int[] res = new int[n];
        helper(n, 0, res);
        
        return res;
    }
    
    private void helper(int n, int offset, int[] arr) {
        if (n == 0)
            return;
        if (n == 1) {
            arr[offset] = 0;
            return;
        }
        
        helper(n - 2, offset + 1, arr);
        arr[offset] = n / 2;
        arr[arr.length - 1 - offset] = - n / 2;
    }
}
