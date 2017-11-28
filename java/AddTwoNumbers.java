/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = null, cur = null;
        int carrier = 0;
        
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + carrier;
            carrier = val / 10;
            if (cur != null) {
                cur.next = new ListNode(val % 10);
                cur = cur.next;
            } else {
                root = new ListNode(val % 10);
                cur = root;
            }
            
            l1 = l1.next;
            l2 = l2.next;
        }
        
        ListNode remaining;
        if (l1 != null) {
            remaining = l1;
        } else {
            remaining = l2;
        }
        
        if (cur != null) {
            cur.next = remaining;
        } else {
            root = remaining;
        }
        
        while (carrier > 0) {
            if (cur.next != null) {
                int val = cur.next.val + carrier;
                carrier = val / 10;
                cur.next.val = val % 10;
                cur = cur.next;
            } else {
                cur.next = new ListNode(carrier);
                carrier = 0;
            }
        }
        return root;
    }
}
