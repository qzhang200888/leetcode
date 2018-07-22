class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        if (S == null || S.length() == 0)
            return res;
        
        char[] chars = S.toCharArray();
        int i = 0;
        
        while (i < chars.length) {
            char c = chars[i];
            int j = i + 1;
            while (j < chars.length && chars[j] == c)
                ++j;
            if (j - i >=3) {
                res.add(Arrays.asList(i, j - 1));
            }
            
            i = j;
        }
        
        return res;
    }
}
