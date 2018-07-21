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
    int pathSumFrom(TreeNode root, int sum) {
        if (root == null)
            return 0;
        
        int res = 0;
        if (root.val == sum)
            ++res;
        
        res += pathSumFrom(root.left, sum - root.val);
        res += pathSumFrom(root.right, sum - root.val);
        
        return res;
    }
    
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        
        int res = 0;
        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);
        
        res += pathSumFrom(root, sum);
        
        return res;
    }
}

// use presum

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
    int pathSum(TreeNode n, int presum, int sum, Map<Integer, Integer> map) {
        int count = 0;
        if (n == null)
            return count;
        
        presum += n.val;
        int key = presum - sum;
        if (map.containsKey(key))
            count += map.get(key);
        map.put(presum, map.getOrDefault(presum, 0) + 1);
        
        count += pathSum(n.left, presum, sum, map);
        count += pathSum(n.right, presum, sum, map);
        
        map.put(presum, map.get(presum) - 1);
        
        return count;
    }
    
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return pathSum(root, 0, sum, map);
    }
}
