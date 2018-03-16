/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        
        RandomListNode newHead = new RandomListNode(head.label);
        
        RandomListNode n1 = head;
        RandomListNode n2 = newHead;
        map.put(n1, n2);
        while (n1.next != null) {
            n2.next = new RandomListNode(n1.next.label);
            n1 = n1.next;
            n2 = n2.next;
            map.put(n1, n2);
        }
        
        n1 = head;
        n2 = newHead;
        
        while (n1 != null) {
            if (n1.random != null) {
                n2.random = map.get(n1.random);
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        
        return newHead;
    }
}
