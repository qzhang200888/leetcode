/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    class MyNode {
        public TreeNode node;
        public int vLevel;
        public MyNode(TreeNode node, int vLevel) {
            this.node = node;
            this.vLevel = vLevel;
        }
    }
    
    /**
     * @param root: the root of tree
     * @return: the vertical order traversal
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
            
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<MyNode> queue = new LinkedList<>();
        queue.offer(new MyNode(root, 0));
        int min = 0, max = 0;
        while (!queue.isEmpty()) {
            MyNode n = queue.poll();
            List<Integer> lst = map.getOrDefault(n.vLevel, new ArrayList<>());
            lst.add(n.node.val);
            map.put(n.vLevel, lst);
            min = Math.min(min, n.vLevel);
            max = Math.max(max, n.vLevel);
            if (n.node.left != null) {
                queue.offer(new MyNode(n.node.left, n.vLevel - 1));
            }
            if (n.node.right != null) {
                queue.offer(new MyNode(n.node.right, n.vLevel + 1));
            }
        }
        
        for (int i = min; i <= max; ++i) {
            res.add(map.get(i));
        }
        return res;
    }
}
