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
    TreeNode flattenTree(TreeNode root) {
        if (root == null)
            return null;
        
        TreeNode leftTail = flattenTree(root.left);
        TreeNode rightTail = flattenTree(root.right);
        
        if (leftTail != null) {
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        
        if (rightTail != null)
            return rightTail;
        
        if (leftTail != null)
            return leftTail;
        
        return root;
    }
    
    public void flatten(TreeNode root) {
        flattenTree(root);
    }
}
