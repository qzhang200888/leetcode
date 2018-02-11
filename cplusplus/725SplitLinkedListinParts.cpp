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
    vector<ListNode*> splitListToParts(ListNode* root, int k) {
        int count = 0;
        ListNode *head = root;
        while (head != NULL) {
            ++count;
            head = head->next;
        }
        
        int average = count / k;
        int mod = count % k;
        
        head = root;
        count = 0;
        vector<ListNode*> res;
        while (head != NULL) {
            ++count;
            if ((count == average && mod == 0) || (count > average) ) {
                res.push_back(root);
                root = head->next;
                head->next = NULL;
                head = root;
                count = 0;
                if (mod > 0)
                    --mod;
            } else {
                head = head->next;
            }
        }
        
        while (res.size() < k)
            res.push_back(NULL);
        
        return res;
    }
};
