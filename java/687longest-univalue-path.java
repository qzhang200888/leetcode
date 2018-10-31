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
    int[] helper(TreeNode root) {
        if (root == null)
            return new int[] {0, 0};
        int longestPath = 0, curPath = 0;
        if (root.left != null) {
            int[] left = helper(root.left);
            longestPath = left[0];
            if (root.val == root.left.val) {
                curPath = left[1] + 1;
                if (longestPath < curPath)
                    longestPath = curPath;
            }
        }
        
        if (root.right != null) {
            int[] right = helper(root.right);
            if (longestPath < right[0])
                longestPath = right[0];
            if (root.val == root.right.val) {
                if (curPath + right[1] + 1 > longestPath)
                    longestPath = curPath + right[1] + 1;
                if (curPath < right[1] + 1)
                    curPath = right[1] + 1;
            }
        }
        return new int[] {longestPath, curPath};
    }
    
    public int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;
        
        return helper(root)[0];
    }
}
