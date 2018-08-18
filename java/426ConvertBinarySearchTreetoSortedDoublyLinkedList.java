/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }
 */


public class Solution {
    DoublyListNode[] getDoublelyList(TreeNode node) {
        if (node == null)
            return new DoublyListNode[2];
            
        DoublyListNode dn = new DoublyListNode(node.val);
        DoublyListNode head = dn, tail =dn;
        
        DoublyListNode[] leftList = getDoublelyList(node.left);
        if (leftList[0] != null) {
            head = leftList[0];
            leftList[1].next = dn;
            dn.prev = leftList[1];
        }
        
        DoublyListNode[] rightList = getDoublelyList(node.right);
        if (rightList[0] != null) {
            tail = rightList[1];
            rightList[0].prev = dn;
            dn.next = rightList[0];
        }
        
        return new DoublyListNode[] {head, tail};
    }
    /*
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    public DoublyListNode bstToDoublyList(TreeNode root) {
        DoublyListNode[] doublyList = getDoublelyList(root);
        return doublyList[0];
    }
}
