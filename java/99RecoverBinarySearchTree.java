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
    TreeNode prev, first, second;
    
    void transverse(TreeNode node) {
        if (node.left != null)
            transverse(node.left);
        
        if (node.val < prev.val) {
            if (first == null) {
                first = prev;
                second = node;
            } else {
                second = node;
                return;
            }
        }
        
        prev = node;
        
        if (node.right != null) {
            transverse(node.right);
        }
            
    }
    
    public void recoverTree(TreeNode root) {
        if (root == null)
            return;
        
        prev = new TreeNode(Integer.MIN_VALUE);
        first = null;
        second = null;
        
        transverse(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
}
