/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode *root = NULL, *curNode = root;
        
        int carrier = 0;
        
        while (l1 != NULL && l2 != NULL) {
            int val = l1->val + l2-> val + carrier;
            carrier = val / 10;
            if (curNode == NULL) {
                root = new ListNode(val % 10);
                curNode = root;
            } else {
                curNode->next = new ListNode(val % 10);
                curNode = curNode->next;
            }
            
            l1 = l1->next;
            l2 = l2->next;
        }
        
        if (l1 != NULL) {
            if (curNode != NULL)
                curNode->next = l1;
            else root = l1;
        } else {
            if (curNode != NULL)
                curNode->next = l2;
            else root = l2;
        }
        
        while (curNode != NULL && curNode->next != NULL && carrier > 0) {
            int val = curNode->next->val + carrier;
            carrier = val / 10;
            curNode->next->val = val % 10;
            curNode = curNode->next;
        }
        
        if (carrier > 0) {
            if (curNode != NULL)
                curNode->next = new ListNode(carrier);          
        }
        return root;
    }
};
