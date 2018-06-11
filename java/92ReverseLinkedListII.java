/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode next = head.next;
        head.next = null;
        while (next != null) {
            ListNode nextnext = next.next;
            next.next = head;
            head = next;
            next = nextnext;
        }

        return head;
    }
    
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n)
            return head;
        ListNode first = head;
        int count = 1;
        while (count < m - 1) {
            first = first.next;
            ++count;
        }
        
        ListNode second = first.next;
        ListNode sublist = first.next;
        if (m > 1)
            first.next = null;
        ++count;
        
        while (count < n) {
            second = second.next;
            ++count;
        }
        
        ListNode next = second.next;
        second.next = null;
        second = next;
        
        if (m > 1)
            first.next = reverseList(sublist);
        else {
            head = reverseList(head);
            first = head;
        }
        while (first.next != null)
            first = first.next;
        
        first.next = second;
        
        return head;
    }
}
