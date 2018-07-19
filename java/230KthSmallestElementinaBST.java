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
    int[] getSizeAndKth(TreeNode root, int k) {
        int [] res = new int[2];
        if (root == null) return res;
        
        int[] left = new int[2];
        if (root.left != null) {
            left = getSizeAndKth(root.left, k);
            if (left[0] >= k)
                return left;
        }
        
        ++left[0];
        if (left[0] == k) {
            left[1] = root.val;
            return left;
        }
        
        int[] right = new int[2];
        if (root.right != null) {
            right = getSizeAndKth(root.right, k - left[0]);
            left[0] += right[0];
            if (left[0] >= k) {
                left[1] = right[1];
            }
        }
            
        return left;
    }
    
    public int kthSmallest(TreeNode root, int k) {
        int[] res = getSizeAndKth(root, k);
        return res[1];
    }
}

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
    int[] transverse(TreeNode n, int k) {
        if (n == null)
            return new int[]{0, 0};
        int[] left = transverse(n.left, k);
        
        if (left[1] >= k)
            return left;
        else if (left[1] == k - 1)
            return new int[]{n.val, k};
        else {
            int[] right = transverse(n.right, k - left[1] - 1);
            return new int[] {right[0], left[1] + 1 + right[1]};
        }
    }
    
    public int kthSmallest(TreeNode root, int k) {
        int[] tr = transverse(root, k);
        return tr[0];
    }
}
