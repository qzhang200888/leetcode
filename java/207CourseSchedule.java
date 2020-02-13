class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] prerequisitNum = new int[numCourses];
        for (int[] pre: prerequisites) {
            List<Integer> lst = map.getOrDefault(pre[1], new ArrayList<>());
            lst.add(pre[0]);
            map.put(pre[1], lst);
            ++prerequisitNum[pre[0]];
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (prerequisitNum[i] == 0)
                queue.offer(i);
        }
        
        if (queue.isEmpty()) {
            return false;
        }
        
        int size = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            ++size;
            if (!map.containsKey(course))
                continue;
            
            for (int neighbor: map.get(course)) {
                --prerequisitNum[neighbor];
                if (prerequisitNum[neighbor] == 0)
                    queue.offer(neighbor);
            }
        }
        
        return size == numCourses;
    }
}
