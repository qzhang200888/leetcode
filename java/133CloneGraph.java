/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return node;
        
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Stack<UndirectedGraphNode> stack = new Stack<>();
        stack.push(node);
        
        while (!stack.isEmpty()) {
            UndirectedGraphNode n = stack.pop();
            UndirectedGraphNode newNode = null;
            if (!map.containsKey(n)) {
                newNode = new UndirectedGraphNode(n.label);
                map.put(n, newNode);
            } else {
                newNode = map.get(n);
            }
            
            for (UndirectedGraphNode neighbor: n.neighbors) {
                if (map.containsKey(neighbor)) {
                    newNode.neighbors.add(map.get(neighbor));
                } else {
                    UndirectedGraphNode newNeighbor = new UndirectedGraphNode(neighbor.label);
                    newNode.neighbors.add(newNeighbor);
                    map.put(neighbor, newNeighbor);
                    stack.push(neighbor);
                }
            }
        }
        
        return map.get(node);
    }
}
