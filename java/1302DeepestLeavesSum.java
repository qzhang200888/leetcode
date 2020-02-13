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
    public int deepestLeavesSum(TreeNode root) {
        if (root == null)
            return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        calLeaveValues(root, 1, map);
        
        int res = 0;
        int maxKey = 0;
        for (int key: map.keySet()) {
            if (key > maxKey) {
                res = map.get(key);
                maxKey = key;
            }
        }
        
        return res;
    }
    
    void calLeaveValues(TreeNode node, int level, Map<Integer, Integer> map) {
        if (node.left == null && node.right == null) {
            int sum = 0;
            if (map.containsKey(level)) {
                sum = map.get(level);
            }
            
            sum += node.val;
            map.put(level, sum);
            
            return;
        }
        
        if (node.left != null)
            calLeaveValues(node.left, level + 1, map);
        
        if (node.right != null)
            calLeaveValues(node.right, level + 1, map);
    }
}
