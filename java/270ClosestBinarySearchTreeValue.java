/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    public int closestValue(TreeNode root, double target) {
        if (target <= root.val) {
            if (root.left == null)
                return root.val;
            int leftCloset = closestValue(root.left, target);
            if (Math.abs(target - leftCloset) < Math.abs(target - root.val))
                return leftCloset;
                
            return root.val;
        }
    
        if (root.right == null)
                return root.val;
        int rightCloset = closestValue(root.right, target);
        if (Math.abs(target - rightCloset) < Math.abs(target - root.val))
            return rightCloset;
                
        return root.val;
    }
}
