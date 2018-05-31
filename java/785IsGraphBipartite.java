//bfs

class Solution {
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0)
            return true;
        
        int[] vertices = new int[graph.length];
        for (int i = 0; i < vertices.length; ++i) {
            if (vertices[i] != 0)
                continue;
            
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            int color = 1;
            while (!q.isEmpty()) {
                int size = q.size();
                for (int j = 0; j < size; ++j) {
                    int k = q.poll();
                    vertices[k] = color;
                    
                    for (int neighbor: graph[k]) {
                        if (vertices[neighbor] != 0) {
                            if (vertices[neighbor] == color)
                                return false;
                        } else
                            q.add(neighbor);
                    }
                }
                
                color *= -1;
            }
            
        }
        
        return true;
    }
}
