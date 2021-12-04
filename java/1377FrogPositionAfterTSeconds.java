class Solution {
    class Pos {
        public int vertex;
        public double prob;
        public Set<Integer> visited;
            
        Pos(int vertex, double prob, Set<Integer> set) {
            this.vertex = vertex;
            this.prob = prob;
            visited = new HashSet<>(set);
        }
    }
    
    public double frogPosition(int n, int[][] edges, int t, int target) {
        if (edges.length == 0) {
            if (target == 1)
                return 1.0;
            return 0.0;
        }
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge: edges) {
            if(!map.containsKey(edge[0])) {
                map.put(edge[0], new ArrayList<>());
            }
            if(!map.containsKey(edge[1])) {
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        
        Queue<Pos> queue = new LinkedList<>();
        
        Pos p = new Pos(1, 1.0, new HashSet<>());
        queue.add(p);
        int step = 1;
        
        double prob = 0.0;
        while (!queue.isEmpty() && step < t) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                p = queue.poll();
                List<Integer> neighbors = map.getOrDefault(p.vertex, new ArrayList<>());
                int count = 0;
                for (int nb: neighbors) {
                    if (!p.visited.contains(nb)) {
                        ++count;
                    }
                }
                
                if (count == 0) {
                    if (p.vertex == target)
                        prob += p.prob;
                    continue;
                }
                double pb = p.prob / count;
                for (int nb: neighbors) {
                    if (!p.visited.contains(nb)) {
                        Pos np = new Pos(nb, pb, p.visited);
                        np.visited.add(p.vertex);
                        queue.add(np);
                    }
                }
            }
            
            ++step;
        }
        
        int size = queue.size();
        for (int i = 0; i < size; ++i) {
            p = queue.poll();
            List<Integer> neighbors = map.get(p.vertex);
            int count = 0;
            for (int nb: neighbors) {
                if (!p.visited.contains(nb)) {
                    ++count;
                }
            }
                
            if (count == 0) {
                if (p.vertex == target)
                    prob += p.prob;
                continue;
            }

            for (int nb: neighbors) {
                if (!p.visited.contains(nb) && nb == target) {
                    prob += p.prob / count;
                }
            }
        }
        
        return prob;
    }
}
