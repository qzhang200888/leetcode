class Solution {
    public int knightDialer(int n) {
        long[] arr = new long[10];
        long[] temp = new long[10];
        
        for (int i = 0; i < 10; ++i) {
            arr[i] = 1;
        }
        
        long mod = (long)Math.pow(10, 9) + 7;
        for (int i = 1; i < n; ++i) {
            temp[0] = (arr[4] + arr[6]) % mod;
            temp[1] = (arr[6] + arr[8]) % mod;;
            temp[2] = (arr[7] + arr[9]) % mod;;
            temp[3] = (arr[4] + arr[8]) % mod;;
            temp[4] = (arr[3] + arr[9] + arr[0]) % mod;;
            temp[5] = 0;
            temp[6] = (arr[1] + arr[7] + arr[0]) % mod;;
            temp[7] = (arr[2] + arr[6]) % mod;;
            temp[8] = (arr[1] + arr[3]) % mod;;
            temp[9] = (arr[4] + arr[2]) % mod;;
            
            long[] tmp = arr;
            arr = temp;
            temp = tmp;
        }

        long sum = 0;
        for (int i = 0; i < 10; ++i)
            sum += arr[i];
        
        return (int)(sum % mod);
    }
}
