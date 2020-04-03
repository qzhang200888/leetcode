class Solution {
    boolean isSmimilar(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i))
                ++count;
            if (count > 2)
                return false;
        }
        
        return true;
    }
    
    int findAncestor(int[] parents, int i) {
        if (parents[i] == i)
            return i;
        return findAncestor(parents, parents[i]);
    }
    
    void union(int i, int j, int[] parents) {
        int ele1 = findAncestor(parents, i);
        int ele2 = findAncestor(parents, j);
        if (ele1 != ele2)
            parents[ele1] = ele2;
        
    }
    public int numSimilarGroups(String[] A) {
        int[] parents = new int[A.length];
        for (int i = 0; i < A.length; ++i)
            parents[i] = i;
        for (int i = 0; i < A.length - 1; ++i) {
            for (int j = 0; j < A.length; ++j) {
                if (isSmimilar(A[i], A[j]))
                    union(i, j, parents);
            }
        }
        
        Set<Integer> set = new HashSet<>();
        for (int p: parents) {
            set.add(findAncestor(parents, p));
        }
        
        return set.size();
    }
}
