public class Solution {
    /**
     * @param words: a list of words
     * @return: a string which is correct order
     */
    public String alienOrder(String[] words) {
        // Write your code here
        Map<Character, List<Character>> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < words.length; ++i) {
            for (int j = 0; j < words[i].length(); ++j)
                set.add(words[i].charAt(j));
        }

        for (int i = 0; i < words.length - 1; ++i) {
            int len = Math.min(words[i].length(), words[i+1].length());
            int j = 0;
            for (j = 0; j < len; ++j) {
                if (words[i].charAt(j) != words[i+1].charAt(j)) {
                    if (!map.containsKey(words[i].charAt(j)))
                        map.put(words[i].charAt(j), new ArrayList<>());
                    map.get(words[i].charAt(j)).add(words[i+1].charAt(j));
                    break;
                }
            }

            if (j == len && words[i].length() > len)
                return "";
        }

        for (char key: map.keySet()) {
            Collections.sort(map.get(key), Collections.reverseOrder());
        }

        StringBuilder sb = new StringBuilder();
        if (!getOrder(map, set, sb))
            return "";

        String str = sb.toString();
        if (set.isEmpty())
            return str;
    
        List<Character> lst = new ArrayList<>(set);
        Collections.sort(lst);

        int i = 0, j = 0;
        sb = new StringBuilder();
        while (i < str.length() && j < lst.size()) {
            if (str.charAt(i) < lst.get(j)) {
                sb.append(str.charAt(i));
                ++i;
            } else {
                sb.append(lst.get(j));
                ++j;
            }
        }

        if (i < str.length()) {
            sb.append(str.substring(i));
        }

        while (j < lst.size()) {
            sb.append(lst.get(j));
            ++j;
        }

        return sb.toString();
    }

    boolean getOrder(Map<Character, List<Character>> map, Set<Character> set, char c, Stack<Character> stack, Set<Character> path) {
        if (path.contains(c)) {
            return false;
        }

        if (set.contains(c))
            return true;
        set.add(c);

        if (!map.containsKey(c)) {
            stack.push(c);
            return true;
        }

        path.add(c);
        for (char neighbor: map.get(c)) {
            if (!getOrder(map, set, neighbor, stack, path)) {
                return false;
            }
        }
        path.remove(c);
        stack.push(c);

        return true;
    }

    boolean getOrder(Map<Character, List<Character>> map, Set<Character> chars, StringBuilder sb) {
        Stack<Character> stack = new Stack<>();
        Set<Character> set = new HashSet<>();
        Set<Character> path = new HashSet<>();

        for (char c: map.keySet()) {
            if (!getOrder(map, set, c, stack, path)) 
                return false;
        }

        while (!stack.isEmpty()) {
            char ch = stack.pop();
            sb.append(ch);
            chars.remove(ch);
        }

        return true;
    }
}
