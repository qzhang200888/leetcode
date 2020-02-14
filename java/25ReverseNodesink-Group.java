/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return head;

        int i = 1;
        ListNode n = head;
        ListNode next = head.next;
        ListNode temp;
        while (next != null && i < k) {
            temp = next.next;
            next.next = n;
            n = next;
            next = temp;
            ++i;
        }
        
        if (i < k) {
            while (n != head) {
                ListNode prev = n.next;
                n.next = next;
                next = n;
                n = prev;
            }
            
            n.next = next;
            return head;
        }
        
        temp = n;
        n = head;
        head = temp;
        
        n.next = reverseKGroup(next, k);
        
        return head;
    }
}

==============================================================

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    ListNode revert(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode cur = head.next;
        head.next = null;
        ListNode prev = head;
        
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return head;
        int count = 0;
        ListNode node = head;
        while (node != null) {
            ++count;
            if (count >= k)
                break;
            node = node.next;
        }
        
        if (count < k)
            return head;
        
        ListNode next = node.next;
        node.next = null;
        
        ListNode res = revert(head);
        head.next = reverseKGroup(next, k);
        
        return res;
    }
}
