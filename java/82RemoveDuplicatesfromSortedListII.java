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
        while (head != null && head.next != null && head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val)
                head = head.next;
            head = head.next;
        }
        
        if (head == null || head.next == null)
            return head;
        
        ListNode n = head;
        while (n != null && n.next != null && n.next.next != null) {
            if (n.next.val == n.next.next.val) {
                while (n.next.next != null && n.next.val == n.next.next.val)
                    n.next = n.next.next;
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
        
        return head;
    }
}
