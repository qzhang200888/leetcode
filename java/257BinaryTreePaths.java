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
    void binaryTreePaths(TreeNode node, String path, List<String> lst) {
        path += "->" + node.val;
        if (node.left == null && node.right == null) {
            lst.add(path);
            return;
        }
        
        if (node.left != null)
            binaryTreePaths(node.left, path, lst);
        if (node.right != null)
            binaryTreePaths(node.right, path, lst);
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList();
        if (root == null)
            return res;
        String path = "" + root.val;
        if (root.left == null && root.right == null) {
            res.add(path);
            return res;
        }
        
        if (root.left != null)
            binaryTreePaths(root.left, path, res);
        if (root.right != null)
            binaryTreePaths(root.right, path, res);
        
        return res;
    }
}
