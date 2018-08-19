class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if (S == null || S.length() == 0)
            return res;
        
        int[] map = new int[26];
        char[] charList = S.toCharArray();
        for (int i = 0; i < charList.length; ++i) {
            map[charList[i] - 'a'] = i;
        }
        
        int start = 0, last = 0;
        for (int i = 0; i < charList.length; ++i) {
            last = Math.max(map[charList[i] - 'a'], last);
            if (i == last) {
                res.add(i - start + 1);
                ++last;
                start = last;
            }
        }
        
        return res;
    }
}
