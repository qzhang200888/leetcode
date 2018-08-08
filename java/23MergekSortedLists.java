/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>(10, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode n1, ListNode n2) {
                return n1.val - n2.val;
            }
        });
        
        for (int i = 0; i < lists.length; ++i) {
            if (lists[i] != null)
                pq.offer(lists[i]);
        }
        
        ListNode dummy = new ListNode(0);
        ListNode n = dummy;
        
        while (!pq.isEmpty()) {
            ListNode smallest = pq.poll();
            if (smallest.next != null)
                pq.offer(smallest.next);
            
            n.next = smallest;
            smallest.next = null;
            n = n.next;
        }
        
        return dummy.next;
    }
}
