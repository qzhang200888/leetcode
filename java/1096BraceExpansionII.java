class Solution {
    int getCloseMark(String expression, int idx) {
        int count = 0;
        for (int i = idx; i < expression.length(); ++i) {
            if (expression.charAt(i) == '{')
                ++count;
            else if (expression.charAt(i) == '}')
                --count;
            if (count == 0)
                return i;
        }
        
        return -1;
    }
    
    Set<String> merge(Set<String> set1, Set<String> set2) {
        if (set2.isEmpty()) {
            return set1;
        } else if (set1.isEmpty()) {
            return set2;
        }
        
        Set<String> set = new HashSet<>();
        for (String str1: set1) {
            for (String str2: set2)
                set.add(str1 + str2);
        }
        
        return set;
    }
    
    Set<String> merge(Set<String> set, char c) {             if (set.isEmpty()) {
            set.add("" + c);
            return set;
        }
                                                     
        Set<String> res = new HashSet<>();
        for (String s: set) {
            res.add(s + c);
        }
        
        return res;
    }
    
    Set<String> helper(String expression) {
        Set<String> set = new HashSet<>();
        Set<String> tmp = new HashSet<>();
        int i = 0;
        while (i < expression.length()) {
            char c = expression.charAt(i);
            if (c == '{') {
                int closeIdx = getCloseMark(expression, i);
                tmp = merge(tmp, helper(expression.substring(i + 1, closeIdx)));
                i = closeIdx + 1;
            } else if (c == ',') {
                set.addAll(tmp);
                tmp.clear();
                ++i;
            } else {
                tmp = merge(tmp, c);
                ++i;
            }
        }
        
        set.addAll(tmp);
        return set;
    }
        
    public List<String> braceExpansionII(String expression) {
        Set<String> set = helper(expression);
        List<String> lst = new ArrayList<>(set);
        Collections.sort(lst);

        return lst;
    }
}