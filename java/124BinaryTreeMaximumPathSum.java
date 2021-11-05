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
    List<Integer> maxPath(TreeNode root) {
        if (root == null)
            return Arrays.asList(0, 0);
        
        List<Integer> leftValues = maxPath(root.left);
        List<Integer> rightValues = maxPath(root.right);
        
        int psum = 0;
        
        if (root.left != null && leftValues.get(1) > 0)
            psum += leftValues.get(1);
        if (root.right != null && rightValues.get(1) > 0)
            psum += rightValues.get(1);
        psum += root.val;
        
        int max = psum;
        if (root.left != null)
            max = Math.max(leftValues.get(0), max);
        if (root.right != null)
            max = Math.max(rightValues.get(0), max);
        
        int path = root.val;
        if (Math.max(leftValues.get(1), rightValues.get(1)) > 0)
            path += Math.max(leftValues.get(1), rightValues.get(1));
        
        return Arrays.asList(max, path);
    }
    
    public int maxPathSum(TreeNode root) {
        return maxPath(root).get(0);
    }
}

///

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
    int[] maxPathSumHelper(TreeNode node) {
        int path = node.val, max = node.val;
        
        if (node.left != null && node.right != null) {
            int[] left = maxPathSumHelper(node.left);
            int[] right = maxPathSumHelper(node.right);
            
            if (left[0] > right[0])
                path += left[0];
            else path += right[0];

            max = Math.max(max, node.val + left[0] + right[0]);
            max = Math.max(max, left[1]);
            max = Math.max(max, right[1]);
        } else if (node.left != null) {
            int[] left = maxPathSumHelper(node.left);
            
            path += left[0];
            max = Math.max(max, left[1]);
        }
        else if (node.right != null) {
            int[] right = maxPathSumHelper(node.right);
            
            path += right[0];
            max = Math.max(max, right[1]);
        }
        
        path = Math.max(node.val, path);
        max = Math.max(max, path);
        
        return new int[] {path, max};
    }
    
    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        
        int[] res = maxPathSumHelper(root);
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
    int[] maxPathSumHelper(TreeNode root) {  
        int path = root.val;
        int max = root.val;
        if (root.left != null) {
            int[] left = maxPathSumHelper(root.left);
            if (left[1] > 0) {
                path += left[1];
                if (max < path)
                    max = path;
            }
            if (max < left[0])
                max = left[0];
        }
        
        if (root.right != null) {
            int[] right = maxPathSumHelper(root.right);
            if (right[1] > 0) {
                if (path + right[1] > max)
                    max = path + right[1];
                
                if (right[1] + root.val > path) 
                    path = right[1] + root.val;
            }
            
            if (max < right[0])
                max = right[0];
        }
        
        return new int[] {max, path};
    }
    
    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        
        int[] res = maxPathSumHelper(root);
        return res[0];
    }
}

=====================================

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
    int[] maxPathSumPair(TreeNode node) {
        if (node == null) {
            return new int[] {0, 0};
        }
        
        int[] leftPair = maxPathSumPair(node.left);
        int[] rightPair = maxPathSumPair(node.right);
        
        int rootPath = Math.max(leftPair[1], rightPair[1]);
        if (rootPath > 0)
            rootPath +=  node.val;
        else rootPath =  node.val;
        
        int newMax = node.val;
        newMax = Math.max(newMax, leftPair[1] + node.val + rightPair[1]);
        newMax = Math.max(newMax, rootPath);
        if (node.left != null)
            newMax = Math.max(newMax, leftPair[0]);
        if (node.right != null)
            newMax = Math.max(newMax, rightPair[0]);
        
        return new int[] {newMax, rootPath};
    }

    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        return maxPathSumPair(root)[0];
    }
}