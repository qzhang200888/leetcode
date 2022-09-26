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

=====================================================================================

class Solution {
    void generateParenthesis(int n, int len, int balance, int leftCount, StringBuilder sb, List<String> res) {
        if (len == 2 * n) {
            res.add(sb.toString());
            return;
        }
        
        if (balance > 0) {
            sb.append(")");
            generateParenthesis(n, len + 1, balance - 1, leftCount, sb, res);
            sb.setLength(sb.length() - 1);
        }
        
        if (leftCount < n) {
            sb.append("(");
            generateParenthesis(n, len + 1, balance + 1, leftCount + 1, sb, res);
            sb.setLength(sb.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        generateParenthesis(n, 0, 0, 0, sb, res);
        
        return res;
    }
}
