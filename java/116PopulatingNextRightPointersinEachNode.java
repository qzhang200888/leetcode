/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeLinkNode n = queue.remove();
            if (n.left != null)
                queue.add(n.left);
            if (n.right != null)
                queue.add(n.right);
            
            for (int i = 1; i < size; ++i) {
                TreeLinkNode next = queue.remove();
                if (next.left != null)
                    queue.add(next.left);
                if (next.right != null)
                    queue.add(next.right);
                n.next = next;
                n = next;
            }
            
            n.next = null;
        }
    }
}
