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
    boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        if (t == null)
            return false;
        if (s == null)
            return false;
        if (s.val != t.val)
            return false;
        if (isSame(s.left, t.left) && isSame(s.right, t.right))
            return true;
        
        return false;
    }
    
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null)
            return true;
        
        if (s == null)
            return false;

        if (isSame(s, t))
            return true;
        
        if (isSubtree(s.left, t) || isSubtree(s.right, t))
            return true;
        
        return false;
    }
}
