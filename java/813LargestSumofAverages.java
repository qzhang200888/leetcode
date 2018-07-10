class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        if (A == null || A.length == 0)
            return 0;

        double[][] averageSums = new double[K + 1][A.length];
        double[] sums = new double[A.length];
        sums[0] = A[0];
        averageSums[1][0] = sums[0];
        for (int i = 1; i < A.length; ++i) {
            sums[i] = A[i] + sums[i-1];
            averageSums[1][i] = sums[i] / (i + 1);
        }
        
        for (int j = 2; j <= K; ++j) {
            averageSums[j][j - 1] = sums[j - 1];
            for (int i = j; i < A.length; ++i) {
                for (int l = i - 1; l >= j - 2; --l) {
                    double avg = averageSums[j - 1][l] + (sums[i] - sums[l]) / (i - l);
                    if (avg > averageSums[j][i]) {
                        averageSums[j][i] = avg;
                    }
                }
            }
        }
        
        return averageSums[K][A.length - 1];
    }
}

// Use O(n) space:
class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        if (A == null || A.length == 0)
            return 0;

        double[] averageSums = new double[A.length];
        double[] sums = new double[A.length];
        sums[0] = A[0];
        averageSums[0] = sums[0];
        for (int i = 1; i < A.length; ++i) {
            sums[i] = A[i] + sums[i-1];
            averageSums[i] = sums[i] / (i + 1);
        }
        
        for (int j = 2; j <= K; ++j) {
            for (int i = A.length - 1; i >= j - 1; --i) {
                double avg = 0;
                for (int l = i - 1; l >= j - 2; --l) {
                    double temp = averageSums[l] + (sums[i] - sums[l]) / (i - l);
                    if (temp > avg) {
                        avg = temp;
                    }
                }
                
                averageSums[i] = avg;
            }
        }
        
        return averageSums[A.length - 1];
    }
}
