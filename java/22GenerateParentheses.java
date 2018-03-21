class Solution {
    void generateParenthesis(int n, int i, int count, int used, String s, List<String> res) {
        if (i == 2 * n) {
            res.add(s);
            return;
        }
        
        if (count > 0) {
            generateParenthesis(n, i + 1, count - 1, used, s + ")", res);
        }
        
        if (used < n) {
            generateParenthesis(n, i + 1, count + 1, used + 1, s + "(", res);
        }
    }
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<String>();
        generateParenthesis(n, 0, 0, 0, "", res);
        
        return res;
    }
}
