public class Solution {
    /**
     * @param word: a non-empty string
     * @param abbr: an abbreviation
     * @return: true if string matches with the given abbr or false
     */
    public boolean validWordAbbreviation(String word, String abbr) {
        // write your code here
        if (word == null && abbr == null)
            return true;
            
        if (word == null || abbr == null) {
            return false;
        }
        
        int index1 = 0, index2 = 0;
        
        while (index1 < word.length() && index2 < abbr.length()) {
            if (Character.isLetter(abbr.charAt(index2))) {
                if (word.charAt(index1) != abbr.charAt(index2))
                    return false;
                ++index1;
                ++index2;
            } else if (!Character.isDigit(abbr.charAt(index2)))
                return false;
            else {
                if (abbr.charAt(index2) == '0')
                    return false;
                    
                int end = index2 + 1;
                while (end < abbr.length() && Character.isDigit(abbr.charAt(end)))
                    ++end;
                int len = Integer.parseInt(abbr.substring(index2, end));
                index1 += len;
                index2 = end;
            }
        }
        
        if (index1 == word.length() && index2 == abbr.length())
            return true;
            
        return false;
    }
}
