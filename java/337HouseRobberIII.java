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
    public int rob(TreeNode root) {
        if (root == null)
            return 0;
        
        int robChildren = rob(root.left) + rob(root.right);
        int sum = root.val;
        
        if (root.left != null) {
            sum += rob(root.left.left) + rob(root.left.right);
        }

        if (root.right != null) {
            sum += rob(root.right.left) + rob(root.right.right);
        }
        
        return Math.max(sum, robChildren);
    }
}

// faster:

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
    int[] robTree(TreeNode n) {
        if (n == null)
            return new int[2];
        
        int[] left = robTree(n.left);
        int[] right = robTree(n.right);
        
        int max = left[0] + right[0];
        max = Math.max(max, left[1] + right[1] + n.val);
        
        return new int[] {max, left[0] + right[0]};
    }
    
    public int rob(TreeNode root) {
        int[] res = robTree(root);
        
        return res[0];
    }
}
