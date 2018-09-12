class Solution {
    double calc(Map<String, List<String>> graph, Map<String, Double> edges, String start, String end,
               Set<String> visited, double res) {
        for (String neighbor: graph.get(start)) {
            if (neighbor.equals(end)) {
                return res * edges.get(start + neighbor);
            }
            
            if (!visited.contains(neighbor) && edges.containsKey(start + neighbor)) {
                visited.add(neighbor);
                double d = calc(graph, edges, neighbor, end, visited, res * edges.get(start + neighbor));
                visited.remove(neighbor);
                
                if (d != -1.0)
                    return d;
            }
        }
        
        return -1;
    }
    
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Double> edges = new HashMap<>();
        
        for (int i = 0; i < equations.length; ++i) {
            if (!graph.containsKey(equations[i][0]))
                graph.put(equations[i][0], new ArrayList<>());
            if (!graph.containsKey(equations[i][1]))
                graph.put(equations[i][1], new ArrayList<>());
            
            graph.get(equations[i][0]).add(equations[i][1]);
            graph.get(equations[i][1]).add(equations[i][0]);
            
            edges.put(equations[i][0] + equations[i][1], values[i]);
            edges.put(equations[i][1] + equations[i][0], 1.0 / values[i]);            
        }
        
        double[] res = new double[queries.length];
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < res.length; ++i) {
            if (!graph.containsKey(queries[i][0]) || !graph.containsKey(queries[i][1])) {
                res[i] = -1.0;
                continue;
            }
            
            if (queries[i][0].equals(queries[i][1])) {
                res[i] = 1.0;
                continue;  
            }
            
            visited.add(queries[i][0]);
            res[i] = calc(graph, edges, queries[i][0], queries[i][1], visited, 1.0);
            visited.remove(queries[i][0]);
        }
        
        return res;
    }
}
