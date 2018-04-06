class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> letterToStr = new HashMap<Character, String>();
        Map<String, Character> strToLetter = new HashMap<String, Character>();
        
        String[] strs = str.split(" ");
        if (pattern.length() != strs.length)
            return false;
        
        for (int i = 0; i < pattern.length(); ++i) {
            if (letterToStr.containsKey(pattern.charAt(i)) &&
                !strs[i].equals(letterToStr.get(pattern.charAt(i))))
                return false;
            if (strToLetter.containsKey(strs[i]) &&
                pattern.charAt(i) != strToLetter.get(strs[i]))
                return false;
            
            if (!letterToStr.containsKey(pattern.charAt(i))) {
                letterToStr.put(pattern.charAt(i), strs[i]);
                strToLetter.put(strs[i], pattern.charAt(i));
            }
        }
                
        return true;
    }
}
