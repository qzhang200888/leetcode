class Solution {    
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        List<Integer> lst = new ArrayList<>();
        
        if (n <= 2) {
            for (int i = 0; i < n; ++i)
                lst.add(i);
            return lst;
        }
        
        for (int[] e: edges) {
            if (!map.containsKey(e[0])) {
                map.put(e[0], new HashSet<>());
            }
            map.get(e[0]).add(e[1]);
            if (!map.containsKey(e[1])) {
                map.put(e[1], new HashSet<>());
            }
            map.get(e[1]).add(e[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if (map.get(i).size() == 1) {
                queue.add(i);
            }
        }
        
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int node = queue.poll();
                if (map.containsKey(node)) {
                    Set<Integer> set = map.get(node);
                    for (int neighbor: set) {
                        map.get(neighbor).remove(node);
                        map.get(node).remove(neighbor);
                        if (map.get(neighbor).size() == 1)
                            queue.add(neighbor);
                    }
                }
            }
            
            count += size;
            if (count >= n - 2)
                break;
        }

        while (!queue.isEmpty())
            lst.add(queue.poll());
        
        return lst;
    }
}
