class Solution {
    char[] numToChars(int i) {
        switch(i) {
            case 2: return new char[]{'a', 'b', 'c'};
            case 3: return new char[]{'d', 'e', 'f'};
            case 4: return new char[]{'g', 'h', 'i'};
            case 5: return new char[]{'j', 'k', 'l'};
            case 6: return new char[]{'m', 'n', 'o'};
            case 7: return new char[]{'p', 'q', 'r', 's'};
            case 8: return new char[]{'t', 'u', 'v'};
            case 9: return new char[]{'w', 'x', 'y', 'z'};
            default:
        }
        
        return new char[0];
    }
    
    List<String> letterCombinations(char[] digits, int pos, List<String> res) {
        if (pos >= digits.length)
            return res;
        
        char[] chars = numToChars(digits[pos] - '0');
        List<String> newRes = new ArrayList<String>();
        if (pos == 0) {
            res.add("");           
        }
        
        for (String s: res) {
            for (char c: chars)
                newRes.add(s + c);
        }
        
        return letterCombinations(digits, pos + 1, newRes);
    }
    
    public List<String> letterCombinations(String digits) {
        List<String> lst = new ArrayList<String>();
        if (digits == null)
            return lst;
        
        return letterCombinations(digits.toCharArray(), 0, lst);
    }
}
