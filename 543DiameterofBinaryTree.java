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
    int[] dataOfBinaryTree(TreeNode root) {
        if (root == null)
            return new int[] {-1, -1};
        
        int[] leftData = dataOfBinaryTree(root.left);
        int[] rightData = dataOfBinaryTree(root.right);
        
        int diameter = Math.max(leftData[0], rightData[0]);
        diameter = Math.max(diameter, leftData[1] + rightData[1] + 2);
        
        int maxPath = Math.max(leftData[1], rightData[1]) + 1;
        
        return new int[] {diameter, maxPath};
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        
        int[] data = dataOfBinaryTree(root);
        
        return data[0];
    }
}
