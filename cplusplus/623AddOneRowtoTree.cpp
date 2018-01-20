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
    TreeNode* addOneRow(TreeNode* root, int v, int d) {
        if (root == NULL)
            return root;
        
        if (d == 1 ) {
            TreeNode * new_root = new TreeNode(v);
            new_root->left = root;
            return new_root;
        }
        
        if (d == 2) {
            TreeNode *new_left = new TreeNode(v);
            TreeNode *new_right = new TreeNode(v);
            new_left->left = root->left;
            new_right->right = root->right;
            root->left = new_left;
            root->right = new_right;
        } else {
            root->left = addOneRow(root->left, v, d - 1);
            root->right = addOneRow(root->right, v, d - 1);
        }
        return root;
    }
};
