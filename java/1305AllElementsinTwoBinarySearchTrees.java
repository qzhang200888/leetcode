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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        
        if (root1 != null)
            stack1.push(root1);
        if (root2 != null)
            stack2.push(root2);
        
        TreeNode n1;
        if (!stack1.empty()) {
            n1 = stack1.peek();
            while (n1.left != null) {
                stack1.push(n1.left);
                n1 = stack1.peek();
            }        
        }

        TreeNode n2;
        if (!stack2.empty()) {
            n2 = stack2.peek();
            while (n2.left != null) {
                stack2.push(n2.left);
                n2 = stack2.peek();
            }        
        }        
        
        List<Integer> lst = new ArrayList<>();
        
        while (!stack1.empty() && !stack2.empty()) {
            n1 = stack1.peek();
            n2 = stack2.peek();
            if (n1.val < n2.val) {
                lst.add(n1.val);
                stack1.pop();
                
                n1 = n1.right;
                while (n1 != null) {
                    stack1.push(n1);
                    n1 = n1.left;
                }
            } else {
                lst.add(n2.val);
                stack2.pop();

                n2 = n2.right;
                while (n2 != null) {
                    stack2.push(n2);
                    n2 = n2.left;
                }            
            }
        }
 
        while (!stack1.empty()) {
            n1 = stack1.pop();            
            lst.add(n1.val);
            n1 = n1.right;
            while (n1 != null) {
                stack1.push(n1);
                n1 = n1.left;
            }
        }
        
        while (!stack2.empty()) {
            n2 = stack2.pop();
            lst.add(n2.val);
            n2 = n2.right;
            while (n2 != null) {
                stack2.push(n2);
                n2 = n2.left;
            }
        }
        
        return lst;
    }
}