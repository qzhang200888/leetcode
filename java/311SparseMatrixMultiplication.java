public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        if(A == null || B == null || A.length == 0 || B.length == 0 || (A[0].length != B.length)) {
            return new int[][]{};
        }
        
        Map<Integer, int[]> rowInA = new HashMap<>();     // store non-zero rows in A
        Map<Integer, int[]> colInB = new HashMap<>();     // store non-zero cols in B
        
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[0].length; j++) {
                if(A[i][j] != 0) {
                    rowInA.put(i, A[i]);
                    break;
                }
            }
        }
        
        for(int j = 0; j < B[0].length; j++) {
            for(int i = 0; i < B.length; i++) {
                if(B[i][j] != 0) {
                    int[] tmp = new int[B.length];
                    for(int k = 0; k <  B.length; k++) {
                        tmp[k] = B[k][j];
                    }
                    colInB.put(j, tmp);
                    break;
                }
            }
        }
        
        int[][] res = new int[A.length][B[0].length];
        
        for(int i : rowInA.keySet()) {
            for(int j : colInB.keySet()) {
                for(int k = 0; k < A[0].length; k++) {
                    res[i][j] += rowInA.get(i)[k] * colInB.get(j)[k];
                }
            }
        }
        
        return res;
    }
}
