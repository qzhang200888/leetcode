class Solution {
    boolean isPalindrome(String s) {
        if (s == null || s.length() == 0)
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
    
    String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
    
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, List<Integer>> preMap = new HashMap<String, List<Integer>>();
        Map<String, List<Integer>> postMap = new HashMap<String, List<Integer>>();
        Map<String, List<Integer>> reverseMap = new HashMap<String, List<Integer>>();
        
        List<Integer> palList = new ArrayList<Integer>();       
        List<Integer> emptyList = new ArrayList<Integer>();
        
        int j = 0;
        for (String w: words) {
            for (int i = 1; i < w.length(); ++i) {
                if (isPalindrome(w.substring(0, i))) {
                    List<Integer> lst = preMap.getOrDefault(reverse(w.substring(i)), new ArrayList());
                    lst.add(j);
                    preMap.put(reverse(w.substring(i)), lst);
                } 
                
                if (isPalindrome(w.substring(i))) {
                    List<Integer> lst = postMap.getOrDefault(reverse(w.substring(0, i)), new ArrayList());
                    lst.add(j);
                    postMap.put(reverse(w.substring(0, i)), lst);
                }
            }
                        
            if (w.equals(""))
                emptyList.add(j);
            else if (isPalindrome(w))
                palList.add(j);
            else {
                List<Integer> lst = postMap.getOrDefault(w, new ArrayList());
                lst.add(j);
                reverseMap.put(reverse(w), lst);
            }
            ++j;
        }
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        j = 0;
        for (String w: words) {
            if (preMap.containsKey(w)) {
                for (int index: preMap.get(w))
                    if (index != j)
                        res.add(Arrays.asList(j, index));
            }
 
            if (postMap.containsKey(w)) {
                for (int index: postMap.get(w))
                    if (index != j)
                        res.add(Arrays.asList(index, j));
            }
 
            if (reverseMap.containsKey(w)) {
                for (int index: reverseMap.get(w))
                    if (index != j)
                        res.add(Arrays.asList(index, j));
            }
            
            ++j;
        }
        
        for (int i = 0; i < emptyList.size(); ++i) {
            for (j = i + 1; j < emptyList.size(); ++j) {
                res.add(Arrays.asList(emptyList.get(i), emptyList.get(j)));
                res.add(Arrays.asList(emptyList.get(j), emptyList.get(i)));
            }
            
            for (j = 0; j < palList.size(); ++j) {
                res.add(Arrays.asList(emptyList.get(i), palList.get(j)));
                res.add(Arrays.asList(palList.get(j), emptyList.get(i)));
            }               
        }
        
        return res;
    }
}
