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
    int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }

    // depth, burn, burn subtree
    int[] infected(TreeNode root, int start) {
        if (root == null) {
            return new int[] {0, -1, -1};
        }

        if (root.val == start) {
            return new int[] {1, 0, getDepth(root) - 1};   
        }

        int[] burnLeft = infected(root.left, start);
        int[] burnRight = infected(root.right, start);
        int depth = 1 + Math.max(burnLeft[0], burnRight[0]);
        int distance = -1;
        int burnTime = -1;

        if (burnLeft[1] >= 0) {
            distance = burnLeft[1] + 1;
            burnTime = Math.max(burnLeft[2], distance + burnRight[0]);
        } else if (burnRight[1] >= 0) {
            distance = burnRight[1] + 1;
            burnTime = Math.max(burnRight[2], distance + burnLeft[0]);
        }

        return new int[] {depth, distance, burnTime};
    }

    public int amountOfTime(TreeNode root, int start) {
        int[] res = infected(root, start);
        return res[2];
    }
}
