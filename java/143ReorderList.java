/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null)
            return;
        
        ListNode n = head;
        int count = 0;
        Stack<ListNode> stack = new Stack<ListNode>();

        while (n != null) {
            stack.push(n);
            ++count;
            n = n.next;
        }
        
        int half = count / 2;        
        n = head;
        while (half > 0) {
            ListNode node = stack.pop();
            node.next = n.next;
            n.next = node;
            n = node.next;
            
            --half;
        }
        
        n.next = null;
    }
}
