/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int helper(TreeNode node, int sum) {
        if (node == null)
            return sum;
        
        int rightSum = 0;
        if (node.right != null) {
            rightSum = helper(node.right, sum);
            node.val += rightSum;
        } else {
            node.val += sum;
        }
        
        int leftSum = node.val;
        if (node.left != null)
            leftSum = helper(node.left, node.val);
        
        return leftSum;
    }
        
    public TreeNode bstToGst(TreeNode root) {
        helper(root, 0);
        return root;
    }
}
