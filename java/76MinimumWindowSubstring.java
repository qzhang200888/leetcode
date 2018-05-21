class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 ||
            t == null || t.length() == 0)
            return "";
        Map<Character, Integer> map =
            new HashMap<Character, Integer>();
        
        int count = 0;
        for (char c: t.toCharArray()) {
            int fre = map.getOrDefault(c, 0);
            if (fre == 0)
                ++count;
            map.put(c, fre + 1);
        }
        
        int start = 0, end = 0;
        int len = Integer.MAX_VALUE, minStart = -1, minEnd = -1;
        char[] charList = s.toCharArray();
        while (end < charList.length) {
            if (count > 0) {
                if (map.containsKey(charList[end])) {
                    int fre = map.get(charList[end]);
                    --fre;
                    if (fre == 0)
                        --count;
                    map.put(charList[end], fre);
                }
                
                ++end;
            } else {
                while (count == 0 && start < end) {
                    int newLen = end - start + 1;
                    if (newLen < len) {
                        len = newLen;
                        minStart = start;
                        minEnd = end;
                    }
                    if (map.containsKey(charList[start])) {
                        int fre = map.get(charList[start]);
                
                        if (fre == 0)
                            ++count;
                        map.put(charList[start], ++fre);
                    }
                    ++start;   
                }
            }
        }
        
        if (count == 0) {
            while (count == 0 && start < end) {
                int newLen = end - start + 1;
                if (newLen < len) {
                    len = newLen;
                    minStart = start;
                    minEnd = end;
                }
                if (map.containsKey(charList[start])) {
                    int fre = map.get(charList[start]);
                
                    if (fre == 0)
                        ++count;
                    map.put(charList[start], ++fre);
                }
                ++start;   
            }
        }
        
        if (len == Integer.MAX_VALUE)
            return "";
        
        return s.substring(minStart, minEnd);
    }
}
