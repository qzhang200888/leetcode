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

===============================================================================

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
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        int carrier = 0;
        ListNode* cur1 = l1, *cur2 = l2;
        ListNode* res = NULL, *node = NULL;
        
        while (cur1 != NULL || cur2 != NULL) {
            int sum = carrier;
            if (cur1 != NULL) {
                sum += cur1->val;
            }
            
            if (cur2 != NULL) {
                sum += cur2->val;
            }
            
            if (node == NULL) {
                node = new ListNode(sum % 10);
                res = node;
            } else {
                node->next = new ListNode(sum % 10);
                node = node->next;
            }
            
            carrier = sum / 10;
            if (cur1 != NULL) {
                cur1 = cur1->next;
            }
            if (cur2 != NULL) {
                cur2 = cur2->next;
            }
        }
        
        if (carrier > 0) {
            node->next = new ListNode(carrier);
        }
        
        return res;
    }
};
