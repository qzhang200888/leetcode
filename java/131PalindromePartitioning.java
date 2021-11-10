class Solution {
    boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
    
    void partition(String s, int start, List<String> lst, List<List<String>> res) {
        if (start >= s.length()) {
            res.add(new ArrayList<>(lst));
            return;
        }

        for (int i = start + 1; i <= s.length(); ++i) {            
            if (start == i - 1 || isPalindrome(s, start, i - 1)) {
                lst.add(s.substring(start, i));
                partition(s, i, lst, res);
                lst.remove(lst.size() - 1);
            }
        }   
    }

    public List<List<String>> partition(String s) {
        List<String> lst = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        partition(s, 0, lst, res);
        return res;
    }
}
