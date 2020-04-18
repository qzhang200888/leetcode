
class Solution {
    public String customSortString(String S, String T) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); ++i) {
            map.put(S.charAt(i), i);
        }

        Character[] arrs = new Character[T.length()];
        for (int i = 0; i < T.length(); ++i) {
            arrs[i] = T.charAt(i);
        }
        
        Arrays.sort(arrs, new Comparator<Character>() {
            @Override
            public int compare(Character c1, Character c2) {
                if (!map.containsKey(c1) && !map.containsKey(c2))
                    return 0;
            
                if (!map.containsKey(c1))
                    return 1;
                
                if (!map.containsKey(c2))
                    return -1;
                
                return map.get(c1) - map.get(c2);
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for (char c: arrs) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}

====================================================================================

class Solution {
    public String customSortString(String S, String T) {
        char[] chars = T.toCharArray();
        char[] orders = S.toCharArray();
        
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < orders.length; ++i) {
            map.put(orders[i], i);
        }
        
        PriorityQueue<Character> pq = new PriorityQueue(10, new Comparator<Character>() {
            @Override
            public int compare(Character c1, Character c2) {
                if (map.containsKey(c1) && map.containsKey(c2))
                    return map.get(c1) - map.get(c2);
                if (map.containsKey(c1))
                    return -1;
                if (map.containsKey(c2))
                    return 1;
                
                return 0;
            }
        });
        
        for (int i = 0; i < chars.length; ++i) {
            pq.offer(chars[i]);
        }
        
        String s = "";
        while (!pq.isEmpty())
            s += pq.poll();
        
        return s;
    }
}
