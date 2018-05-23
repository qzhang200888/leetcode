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
    void pathSum(List<List<Integer>> res, TreeNode root, int sum, List<Integer> path) {
        if (root == null)
            return;
        
        path.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            res.add(new ArrayList(path));
        }

        if (root.left != null) {
            pathSum(res, root.left, sum - root.val, path);
        }
        
        if (root.right != null) {
            pathSum(res, root.right, sum - root.val, path);
        }

        path.remove(path.size() - 1);
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        pathSum(res, root, sum, path);
        
        return res;
    }
}
