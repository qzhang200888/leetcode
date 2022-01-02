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
    TreeNode parent(TreeNode node, int startValue, int destValue) {
        if (node == null)
            return null;

        if (node.val == startValue || node.val == destValue) {
            return node;
        }
        
        TreeNode left = parent(node.left, startValue, destValue);
        TreeNode right = parent(node.right, startValue, destValue);
        
        if (left == null)
            return right;
        if (right == null)
            return left;
        return node;
    }
    
    String getDirectionToNode(TreeNode node, int target, StringBuilder sb, boolean toDest) {
        if (node == null)
            return null;

        if (node.val == target) {
            return sb.toString();
        }
        
        if (toDest)
            sb.append('L');
        else sb.append('U');
        String str = getDirectionToNode(node.left, target, sb, toDest);
        if (str == null) {
            if (toDest) {
                sb.setLength(sb.length() - 1);
                sb.append('R');
            }
            str = getDirectionToNode(node.right, target, sb, toDest);
        }
        sb.setLength(sb.length() - 1);
        
        return str;
    }
    
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode p = parent(root, startValue, destValue);
        if (p == null)
            return null;
        StringBuilder sb = new StringBuilder();
        
        String str = getDirectionToNode(p, startValue, sb, false);
        
        return str + getDirectionToNode(p, destValue, sb, true);
    }
}
