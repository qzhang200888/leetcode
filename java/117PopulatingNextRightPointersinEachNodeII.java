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
        if (root == null)
            return;
        TreeLinkNode tr = root;
        TreeLinkNode fn = null;
        while (tr != null) {
            TreeLinkNode n = null;
            while (tr != null) {
                if (tr.left != null) {
                    if (n != null) {
                        n.next = tr.left;
                        n = n.next;
                    } else n = tr.left;
                    
                    if (fn == null)
                        fn = tr.left;
                }
                
                if (tr.right != null) {
                    if (n != null) {
                        n.next = tr.right;
                        n = n.next;
                    } else n = tr.right;
                    
                    if (fn == null)
                        fn = tr.right;
                }
                
                tr = tr.next;
            }
            
            if (n != null)
                n.next = null;
            
            tr = fn;
            fn = null;
        }
    }
}
