/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        while (head != null && head.next != null && head.val == head.next.val)
            head = head.next;
        
        ListNode n = head;
        
        while (n != null && n.next != null) {
            while (n != null && n.next != null && n.val == n.next.val)
                n.next = n.next.next;
            n = n.next;
        }
        
        return head;
    }
}
