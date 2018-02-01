/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {   
public:
    TreeNode* sortedListToBST(ListNode* head) {
         if (head == NULL) return NULL;
         if (head->next == NULL) return new TreeNode(head->val);
        
        ListNode *slow = head, *fast = head->next->next;
        while (fast != NULL) {
            fast = fast->next;
            if (fast != NULL) {
                slow = slow->next;
                fast = fast->next;
            }
        }
        
        TreeNode *n = new TreeNode(slow->next->val);
        n->right = sortedListToBST(slow->next->next);
        slow->next = NULL;
        n->left = sortedListToBST(head);
        
        return n;       
    }
};
