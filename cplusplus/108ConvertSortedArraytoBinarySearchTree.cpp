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
    TreeNode* sortedArrayToBST(vector<int>& nums, int start, int end) {
        if (start > end) return NULL;
        int mid = (start + end) / 2;
        TreeNode * n = new TreeNode(nums[mid]);
        n->left = sortedArrayToBST(nums, start, mid - 1);
        n->right = sortedArrayToBST(nums, mid + 1, end);
        
        return n;
    }
public:
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        return sortedArrayToBST(nums, 0, nums.size() - 1);
    }
};
