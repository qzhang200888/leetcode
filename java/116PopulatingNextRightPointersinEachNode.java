
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {    
    public Node connect(Node root) {
        if (root == null)
            return null;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node prev = null;
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                Node n = queue.poll();
                if (n.left != null)
                    queue.add(n.left);
                if (n.left != null)
                    queue.add(n.right);
                if (prev != null)
                    prev.next = n;
                prev = n;
            }
        }
        return root;
    }
}


======================================================
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
