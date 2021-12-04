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
    void delNodes(TreeNode node, Set<Integer> set, boolean addNode, List<TreeNode> lst) {
        if (addNode && !set.contains(node.val)) {
            lst.add(node);
        }
        
        addNode = set.contains(node.val);
        if (node.left != null) {
            delNodes(node.left, set, addNode, lst);
            if (!addNode && set.contains(node.left.val))
                node.left = null;
        }
        if (node.right != null) {
            delNodes(node.right, set, addNode, lst);
            if (!addNode && set.contains(node.right.val))
                node.right = null;
        }
    }
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null)
            return null;
        
        Set<Integer> set = new HashSet<>();
        for (int i: to_delete) {
            set.add(i);
        }
        
        List<TreeNode> lst = new ArrayList<>();
        delNodes(root, set, !set.contains(root.val), lst);
        
        return lst;
    }
}
