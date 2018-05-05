class Solution {
    boolean wordPattern(String pattern, String str, int i, int j, 
			Map<Character, String> letterToStr,
			Map<String, Character> strToLetter) {
        if (i == pattern.length() && j == str.length())
            return true;
			
        if (i == pattern.length() || j == str.length())
            return false;
			
        char c = pattern.charAt(i);
	if (letterToStr.containsKey(c)) {
            String s = letterToStr.get(c);
            if (j + s.length() > str.length())
                return false;
            if (!s.equals(str.substring(j, j + s.length())))
                return false;
		     	
            return wordPattern(pattern, str, i + 1, j + s.length(), letterToStr, strToLetter);
        }
		
        for (int k = j + 1; k < str.length(); ++k) {
            String s = str.substring(j, k);
            if (strToLetter.containsKey(s))
                continue;
				
            letterToStr.put(c, s);
            strToLetter.put(s, c);
			
            if (wordPattern(pattern, str, i + 1, j + s.length(), letterToStr, strToLetter))
                return true;
				
            letterToStr.remove(c);
            strToLetter.remove(s);
        }
		
        return false;
    }

    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> letterToStr = new HashMap<Character, String>();
        Map<String, Character> strToLetter = new HashMap<String, Character>();
                
        return wordPattern(pattern, str, 0, 0, letterToStr, strToLetter);
    }
}
