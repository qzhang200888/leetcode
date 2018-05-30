import java.util.*;

public class LongestSub {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstringKDistinct("eceba", 2));
    }

    static class Solution {
        public int lengthOfLongestSubstringKDistinct(String s, int k) {
            if (s == null || s.length() == 0 || k == 0)
                return 0;

            Map<Character, Integer> map = new HashMap<Character, Integer>();
            int max = 0;
            int start = 0, end = 0;
            int count = 0;
            while (end < s.length()) {
                char c = s.charAt(end);
                int num = map.getOrDefault(c, 0);
                if (num == 0)
                    ++count;
                map.put(c, num + 1);
                while (count > k) {
                    char cc = s.charAt(start);
                    num = map.getOrDefault(cc, 0);
                    map.put(cc, num - 1);
                    if (num == 1)
                        --count;
                    ++start;
                }

                if (max < end - start + 1)
                    max = end - start + 1;

                ++end;
            }

            return max;
        }
    }
}
