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
    List<Integer> maxPath(TreeNode root) {
        if (root == null)
            return Arrays.asList(0, 0);
        
        List<Integer> leftValues = maxPath(root.left);
        List<Integer> rightValues = maxPath(root.right);
        
        int psum = 0;
        
        if (root.left != null && leftValues.get(1) > 0)
            psum += leftValues.get(1);
        if (root.right != null && rightValues.get(1) > 0)
            psum += rightValues.get(1);
        psum += root.val;
        
        int max = psum;
        if (root.left != null)
            max = Math.max(leftValues.get(0), max);
        if (root.right != null)
            max = Math.max(rightValues.get(0), max);
        
        int path = root.val;
        if (Math.max(leftValues.get(1), rightValues.get(1)) > 0)
            path += Math.max(leftValues.get(1), rightValues.get(1));
        
        return Arrays.asList(max, path);
    }
    
    public int maxPathSum(TreeNode root) {
        return maxPath(root).get(0);
    }
}
