/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return head;
        
        ListNode first = head;
        while (n >= 0 && first != null) {
            first = first.next;
            --n;
        }
        
        if (n > 0)
            return head;
        if (n == 0)
            return head.next;
        
        ListNode second = head;
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        
        second.next = second.next.next;
        return head;
    }
}
