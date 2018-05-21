class Solution {
    boolean visit(int course, Map<Integer, List<Integer>> map, Set<Integer> visited, Set<Integer> path, Stack<Integer> stack) {
        if (visited.contains(course)) {
            return true;
        }
        
        visited.add(course);
        
        path.add(course);   
        if (map.containsKey(course)) {
            List<Integer> lst = map.get(course);
            for (int c: lst) {
                if (path.contains(c))
                    return false;
                
                if (!visit(c, map, visited, path, stack))
                    return false;
            }
        }
        
        stack.push(course);
        path.remove(course);
        
        return true;
    }
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < prerequisites.length; ++i) {
            List<Integer> lst = map.getOrDefault(prerequisites[i][1], new ArrayList<Integer>());
            lst.add(prerequisites[i][0]);
            map.put(prerequisites[i][1], lst);
        }
        
        Set<Integer> visited = new HashSet<Integer>();
        Set<Integer> path = new HashSet<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int i = 0; i < numCourses; ++i) {
            path.clear();
            if (!visit(i, map, visited, path, stack))
                return new int[0];
        }
        
        int[] res = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty())
            res[i++] = stack.pop();
        
        return res;
    }
}
