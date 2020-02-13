class Solution {
    public String minRemoveToMakeValid(String s) {
        if (s == null || s.length() == 0)
            return s;
        
        Stack<Integer> stack = new Stack<>();
        Set<Integer> remove = new HashSet<>();
        
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(')
                stack.push(i);
            else if (c == ')') {
                if (stack.size() > 0)
                    stack.pop();
                else remove.add(i);
            } 
        }
        
        while (stack.size() > 0)
            remove.add(stack.pop());
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            if (remove.contains(i))
                continue;
            sb.append(s.charAt(i));
        }
        
        return sb.toString();
    }
}
