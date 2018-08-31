public class Solution {
    /**
     * @param s: the given string
     * @return: if a permutation of the string could form a palindrome
     */
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() < 2)
            return true;
            
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c: chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int countOdd = 0;
        for (char c: map.keySet()) {
            if (map.get(c) % 2 != 0) {
                ++countOdd;
                if (countOdd > 1)
                    return false;
            }
        }
        
        return true;
    }
}
