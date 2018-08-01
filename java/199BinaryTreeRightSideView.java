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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null)
            return res;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size - 1; ++i) {
                TreeNode tn = queue.poll();
                if (tn.left != null)
                    queue.offer(tn.left);
                if (tn.right != null)
                    queue.offer(tn.right);
            }
            
            TreeNode tn = queue.poll();
            if (tn.left != null)
                queue.offer(tn.left);
            if (tn.right != null)
                queue.offer(tn.right);
            
            res.add(tn.val);
        }
        
        return res;
    }
}
