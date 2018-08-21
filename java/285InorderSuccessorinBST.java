/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class Solution {
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null)
            return null;
          
        if (p.val == root.val) {
            if (root.right == null)
                return null;
            TreeNode res = root.right;
            while (res.left != null)
                res = res.left;
            return res;
        } else if (p.val > root.val) {
            if (root.right == null)
                return null;
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode res = inorderSuccessor(root.left, p);
            if (res == null)
                return root;
            return res;
        }
    }
}
