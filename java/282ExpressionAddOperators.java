class Solution {
    void addOperators(String num, int target, int pos, long result, String s, int mul, List<String> solutions) {
        if (pos == num.length()) {
            if (result == target)
                solutions.add(s);
            return;
        }
        
        for (int j = pos + 1; j <= num.length(); ++j) {
            int val;
            try {
                val = Integer.parseInt(num.substring(pos, j));
            } catch (Exception ex) {
                return;
            }
            
            if (pos > 0) {
                addOperators(num, target, j, result + val, s + "+" + num.substring(pos, j), val, solutions);
                addOperators(num, target, j, result - val, s + "-" + num.substring(pos, j), -val, solutions);
                addOperators(num, target, j, result - mul + mul * val, s + "*" + num.substring(pos, j), mul * val, solutions);
            } else {
                addOperators(num, target, j, result + val, s + num.substring(pos, j), val, solutions);
            }
            
            if (j == pos + 1 && val == 0)
                return;
        }
    }
    
    public List<String> addOperators(String num, int target) {
        List<String> solutions = new ArrayList<>();
        addOperators(num, target, 0, 0, "", 0, solutions);
        
        return solutions;
    }
}
