# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        root = None
        cur = root
        carrier = 0
        while l1 != None and l2 != None:
            val = l1.val + l2.val + carrier;
            if cur != None:
                cur.next = ListNode(val % 10)
                carrier = val // 10
                cur = cur.next
            else:
                root = ListNode(val % 10)
                carrier = val // 10
                cur = root 
            l1 = l1.next
            l2 = l2.next
        
        if l1 != None:
            if cur != None:
                cur.next = l1
            else:
                root = l1
        else:
            if cur != None:
                cur.next = l2
            else:
                root = l2
            
        while cur != None and cur.next != None and carrier > 0:
            val = cur.next.val + carrier;
            cur.next.val = val % 10
            carrier = val // 10
            cur = cur.next
            
        if carrier > 0:
            cur.next = ListNode(carrier)
            
        return root
