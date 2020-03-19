class Solution {
    boolean isPalindrome(String s) {
        if (s == null || s.length() < 2)
            return true;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            ++i;
            --j;
        }
        
        return true;
    }
    
    String revert(String s) {
        if (s.length() < 2)
            return s;

        StringBuilder sb = new StringBuilder();
        sb.append(s.toCharArray());
        sb.reverse();
        
        return sb.toString();
    }
   
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> lst = new ArrayList<>();
        if (words == null || words.length <= 1)
            return lst;

        Map<String, List<Integer>> preMap = new HashMap<>();
        Map<String, List<Integer>> postMap = new HashMap<>();

        int index = 0;
        for (String s: words) {
            for (int i = 0; i <= s.length(); ++i) {
                String first = s.substring(0, i);
                String second = s.substring(i);
                
                if (isPalindrome(first)) {
                    String reverse = revert(second);
                    if (!postMap.containsKey(reverse)) {
                        postMap.put(reverse, new ArrayList<Integer>());
                    }
                    postMap.get(reverse).add(index);
                }
                
                if (isPalindrome(second)){
                    String reverse = revert(first);
                    if (!preMap.containsKey(reverse)) {
                        preMap.put(reverse, new ArrayList<Integer>());
                    }
                    preMap.get(reverse).add(index);
                }
            }            
            
            ++index;
        }
        
        index = 0;
        Set<List<Integer>> set = new HashSet<>();
        for (String s: words){
            if (preMap.containsKey(s)) {
                for (int i: preMap.get(s)) {
                    if (i == index)
                        continue;
                    
                    List<Integer> pair = new ArrayList<>();
                    pair.add(i);
                    pair.add(index);
                    if (!set.contains(pair)) {
                        lst.add(pair);
                        set.add(pair);
                    }
                }
            }
            
            if (postMap.containsKey(s)) {
                for (int i: postMap.get(s)) {
                    if (i == index)
                        continue;
                    
                    List<Integer> pair = new ArrayList<>();
                    pair.add(index);
                    pair.add(i);
                    if (!set.contains(pair)) {
                        lst.add(pair);
                        set.add(pair);
                    }
                }
            }
            
            ++index;
        }
        
        return lst;
    }
}
