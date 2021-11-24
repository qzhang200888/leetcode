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
    void getLeaf(TreeNode node, List<Integer> lst) {
        if (node == null)
            return;
        if (node.left != null)
            getLeaf(node.left, lst);
        if (node.right != null)
            getLeaf(node.right, lst);
        if (node.left == null && node.right == null) {
            lst.add(node.val);
        }
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> lst1 = new ArrayList<>();
        List<Integer> lst2 = new ArrayList<>();
        
        getLeaf(root1, lst1);
        getLeaf(root2, lst2);
        
        return lst1.equals(lst2);
    }
}
