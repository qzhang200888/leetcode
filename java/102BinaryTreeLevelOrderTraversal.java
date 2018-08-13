/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> lst = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode tn = queue.poll();
                lst.add(tn.val);
                if (tn.left != null)
                    queue.offer(tn.left);
                if (tn.right != null)
                    queue.offer(tn.right);
            }
            
            res.add(lst);
        }
        
        return res;
    }
}
