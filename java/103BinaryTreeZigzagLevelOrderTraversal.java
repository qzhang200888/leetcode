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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null)
            return res;
        
        Stack<TreeNode> stack = new Stack<>();
        boolean fromLeft = true;
        stack.add(root);
        
        while (!stack.isEmpty()) {
            List<Integer> lst = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>(); 
            while (!stack.isEmpty()) {
                TreeNode tr = stack.pop();
                lst.add(tr.val);
                
                if (fromLeft) {
                    if (tr.left != null)
                        queue.add(tr.left);
                    if (tr.right != null)
                        queue.add(tr.right);
                } else {
                    if (tr.right != null)
                        queue.add(tr.right);
                    if (tr.left != null)
                        queue.add(tr.left);
                }
            }
            
            res.add(lst);
            fromLeft = !fromLeft;
            
            while (!queue.isEmpty())
                stack.add(queue.poll());
        }
        
        return res;
    }
}
