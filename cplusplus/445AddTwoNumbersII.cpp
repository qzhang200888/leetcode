/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
    ListNode *reverse(ListNode *n) {
        if (n == NULL || n->next == NULL) return n;
        
        ListNode *first = n->next, *second = n;
        n->next = NULL;
        while (first != NULL) {
            ListNode *next = first->next;
            first->next = second;
            
            second = first;
            first = next;
        }
        
        return second;
    }
    
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) { 
        ListNode *first = reverse(l1);
        ListNode *second = reverse(l2);
        
        ListNode *res = NULL, *n;
        int carrier = 0;
        
        while (first != NULL && second != NULL) {
            if (res == NULL) {
                res = new ListNode((first->val + second->val + carrier) % 10);
                carrier = (first->val + second->val + carrier) / 10;
                n = res;
            } else {
                n->next = new ListNode((first->val + second->val + carrier) % 10);
                carrier = (first->val + second->val + carrier) / 10;
                n = n->next;
            }
            
            first = first->next;
            second = second->next;
        }
        
        while (second != NULL) {
            if (res == NULL) {
                res = new ListNode((second->val + carrier) % 10);
                carrier = (second->val + carrier) / 10;
                n = res;
            } else {
                n->next = new ListNode((second->val + carrier) % 10);
                carrier = (second->val + carrier) / 10;
                n = n->next;
            }
            second = second->next;          
        }
        
        while (first != NULL) {
            if (res == NULL) {
                res = new ListNode((first->val + carrier) % 10);
                carrier = (first->val + carrier) / 10;
                n = res;
            } else {
                n->next = new ListNode((first->val + carrier) % 10);
                carrier = (first->val + carrier) / 10;
                n = n->next;
            }
            first = first->next;          
        }
        
        if (carrier > 0) {
            n->next = new ListNode(carrier);
        }
        return reverse(res);
    }
};
