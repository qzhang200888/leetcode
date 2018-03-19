class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == t) return true;
        if (s == null || t == null)
            return false;

        char[] charsInS = s.toCharArray();
        char[] charsInT = t.toCharArray();
        
        Arrays.sort(charsInS);
        Arrays.sort(charsInT);
        
        return String.valueOf(charsInS).equals(String.valueOf(charsInT));
    }
}
