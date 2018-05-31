class Solution {
    void letterCasePermutation(char[] s, int pos, char[] word, int length, List<String> res) {
        if (pos >= s.length) {
            res.add((new String(word)).substring(0, length));
            return;
        }
        
        if (Character.isLetter(s[pos])) {
            word[length] = Character.toLowerCase(s[pos]);
            letterCasePermutation(s, pos + 1, word, length + 1, res);
            
            word[length] = Character.toUpperCase(s[pos]);
            letterCasePermutation(s, pos + 1, word, length + 1, res);
        } else {
            word[length] = s[pos];
            letterCasePermutation(s, pos + 1, word, length + 1, res);
        }
    }
    
    public List<String> letterCasePermutation(String S) {
        char[] chars = S.toCharArray();
        char[] word = new char[chars.length];
        List<String> res = new ArrayList<String>();
        
        letterCasePermutation(chars, 0, word, 0, res);
        
        return res;
    }
}
