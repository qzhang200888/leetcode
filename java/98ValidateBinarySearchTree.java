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
    boolean isValidBST(TreeNode root, long max, long min) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max)
            return false;
        
        if (isValidBST(root.left, root.val, min) &&
            isValidBST(root.right, max, root.val))
            return true;
        return false;
    }
    public boolean isValidBST(TreeNode root) {     
        return isValidBST(root, Long.MAX_VALUE, Long.MIN_VALUE); 
    }
}
