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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> lst = new ArrayList<Double>();
        if (root == null)
            return lst;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; ++i) {
                TreeNode tr = queue.poll();
                sum = sum + (double)tr.val;
                if (tr.left != null)
                    queue.add(tr.left);
                if (tr.right != null)
                    queue.add(tr.right);
            }
 
            lst.add(sum / size);
        }
        
        return lst;
    }
}
