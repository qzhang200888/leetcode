/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    Node[] flattenList(Node head) {
        Node[] res = new Node[2];
        if (head == null)
            return res;
        
        Node newHead = new Node(head.val, null, null);
        Node iter = newHead;
        
        Node[] childList = flattenList(head.child);
        iter.next = childList[0];
        if (iter.next != null)
            iter.next.prev = iter;
        if (childList[1] != null)
            iter = childList[1];
        
        Node[] nextList = flattenList(head.next);
        iter.next = nextList[0];
        if (iter.next != null)
            iter.next.prev = iter;
        if (nextList[1] != null)
            iter = nextList[1];
        
        return new Node[] {newHead, iter};
    }
    
    public Node flatten(Node head) {
        Node[] res = flattenList(head);
        
        return res[0];
    }
}
