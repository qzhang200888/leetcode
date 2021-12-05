public class Solution {
    /**
     * @param org: a permutation of the integers from 1 to n
     * @param seqs: a list of sequences
     * @return: true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        if (org.length == 0) {
            if (seqs.length == 0)
                return true;
            for (int[] sq: seqs) {
                if (sq.length > 0)
                    return false;
            }

            return true;
        }
        int[] idx = new int[org.length + 1];
        for (int i = 0; i < org.length; ++i) {
            idx[org[i]] = i;
        }
        
        boolean[] precessor = new boolean[org.length];
        boolean[] found = new boolean[org.length + 1];
        for (int[] sq: seqs) {
            for (int i = 0; i < sq.length; ++i) {
                if (sq[i] < 1 || sq[i] > org.length)
                    return false;
 
                found[sq[i]] = true;
                if (i > 0) {
                    if (idx[sq[i - 1]] > idx[sq[i]])
                        return false;
                    if (idx[sq[i - 1]] + 1 == idx[sq[i]])
                        precessor[idx[sq[i]]] = true;
                }
            }
        }

        found[0] = true;
        for (boolean f: found) {
            if (!f)
                return false;
        }

        precessor[0] = true;
        int i = 0;
        for (boolean p: precessor) {
            if (!p) {
                return false;
            }
            ++i;
        }

        return true;
    }
}
