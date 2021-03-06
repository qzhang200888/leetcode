class Solution {
public:
    int numSquares(int n) {
        int *array = new int[n + 1];
        array[0] = 0;
        
        for (int i = 1; i<=n; ++i) {
            array[i] = n;
            for (int j = 1; j * j <= i; ++j) {
                if (array[i - j * j] + 1 < array[i])
                    array[i] = array[i - j * j] + 1;
            }
        }
     
        int res = array[n];
        delete[] array;
        
        return res;   
    }
};
