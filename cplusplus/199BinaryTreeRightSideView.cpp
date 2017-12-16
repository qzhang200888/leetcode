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
    vector<int> rightSideView(TreeNode* root) {
        vector<int> res;
        rightViewList(root, res, 0);
        
        return res;
    }
    
    void rightViewList(TreeNode *node, vector<int>& list, int level) {
        if (node == NULL) return;
        if (list.size() == level)
            list.push_back(node->val);
        rightViewList(node->right, list, level + 1);
        rightViewList(node->left, list, level + 1);
    }
};
