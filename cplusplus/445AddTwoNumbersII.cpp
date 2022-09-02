/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
    ListNode* revert(ListNode* l1) {
        ListNode *n1 = l1;
        if (n1 == NULL)
            return n1;
        ListNode *n2 = l1->next;
        if (n2 == NULL) {
            return n1;
        }
        
        while (n2->next != NULL) {
            ListNode* newNode = n2->next;
            n2->next = n1;
            n1 = n2;
            n2 = newNode;
        }
        
        n2->next = n1;
        l1->next = NULL;
        return n2;
    }
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        if (l1 == NULL) {
            return l2;
        }
        if (l2 == NULL) {
            return l1;
        }
        ListNode* n1 = revert(l1);
        ListNode* n2 = revert(l2);
        
        int c = 0;
        ListNode* newList = NULL, *n = NULL;
        while (n1 != NULL || n2 != NULL) {
            int v= c;
            if (n1 != NULL) {
                v += n1->val;
                n1 = n1->next;
            }
            if (n2 != NULL) {
                v += n2->val;
                n2 = n2->next;
            }
            if (newList == NULL) {
                newList = new ListNode(v % 10);
                n = newList;
            } else {
                n->next = new ListNode(v % 10);
                n = n->next;
            }
            
            c = v / 10;
        }
        
        if (c != 0) {
            n->next = new ListNode(c);
        }
        return revert(newList);
    }
};

==================================================================

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
