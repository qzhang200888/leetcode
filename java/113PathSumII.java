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
    List<List<Integer>> pathSum(TreeNode root, int sum, List<Integer> path) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                List<Integer> answer = new ArrayList(path);
                answer.add(root.val);
                res.add(answer);
            }

            return res;
        }

        path.add(root.val);
        
        if (root.left != null) {
            List<List<Integer>> leftPaths = pathSum(root.left, sum - root.val, path);
            if (leftPaths.size() > 0) {
                res.addAll(leftPaths);
            }
        }
        
        if (root.right != null) {
            List<List<Integer>> rightPaths = pathSum(root.right, sum - root.val, path);
            if (rightPaths.size() > 0) {
                res.addAll(rightPaths);
            }
        }

        path.remove(path.size() - 1);
        
        return res;
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)
            return new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        return pathSum(root, sum, path);
    }
}
