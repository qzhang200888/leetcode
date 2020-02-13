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
    
    int[] dist(TreeNode node) {
        if (node == null)
            return new int[]{0, -1};

        int[] leftDist = dist(node.left);
        int[] rightDist = dist(node.right);
        
        int[] res = new int[2];
        
        res[1] = Math.max(leftDist[1], rightDist[1]) + 1;
        
        res[0] = Math.max(leftDist[0], rightDist[0]);
        res[0] = Math.max(res[0], leftDist[1] + rightDist[1] + 2);
        
        return res;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = dist(root);
        
        return res[0];
    }
}
