class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if (n <= 0)
            return new int[0];
        
        Stack<Integer> stack = new Stack<>();
        int time = 0;
        int[] res = new int[n];
        for (String s: logs) {
            int pos1 = s.indexOf(':');
            int process = Integer.parseInt(s.substring(0, pos1));
            int pos2 = s.indexOf(':', pos1 + 1);
            int curTime = Integer.parseInt(s.substring(pos2 + 1));
            
            if (!stack.isEmpty())
                res[stack.peek()] += curTime - time;
            time = curTime;
            
            if (s.substring(pos1 + 1, pos2).equals("start")) {
                stack.push(process);
            } else {
                res[stack.peek()]++;
                stack.pop();
                ++time;
            }
        }
        
        return res;
    }
}
