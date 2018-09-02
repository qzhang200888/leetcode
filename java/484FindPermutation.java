public class Solution {
    /**
     * @param s: a string
     * @return: return a list of integers
     */
    public int[] findPermutation(String s) {
        if (s == null || s.length() == 0)
            return new int[] {};
            
        char[] chars = s.toCharArray();
        int[] res = new int[chars.length + 1];
        int cur = 0;
        for (int i = 0; i < chars.length; ++i) {
            if (chars[i] == 'I') {
                int val = i + 1;
                while (cur < i + 1) {
                    res[cur++] = val--;
                }
            }
            
            if (i == chars.length - 1) {
                int val = chars.length + 1;
                while (cur <= chars.length) {
                    res[cur++] = val--;
                }
            }
        }
        
        return res;
    }
}
