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
    ListNode* removeElements(ListNode* head, int val) {
        while (head != NULL && head->val == val)
            head = head->next;
        
        ListNode *n = head;
        while (n != NULL) {
            if (n->next != NULL && n->next->val == val)
                n->next = n->next->next;
            else n = n->next;
        }
            
        return head;
    }
};
