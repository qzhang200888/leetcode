/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        sb.append(root.val);
        if (root.left != null)
            queue.offer(root.left);
        else queue.offer(new TreeNode(1001));
        if (root.right != null)
            queue.offer(root.right);
        else queue.offer(new TreeNode(1001));
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val > 1000)
                sb.append(",");
            else {
                sb.append("," + node.val);
                if (node.left != null)
                    queue.offer(node.left);
                else queue.offer(new TreeNode(1001));
                if (node.right != null)
                    queue.offer(node.right);
                else queue.offer(new TreeNode(1001));
            }
        }
        return sb.toString();
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null)
            return null;
        
        String[] strs = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int idx = 0;
        while (!queue.isEmpty()) {
            ++idx;
            if (idx >= strs.length)
                break;
            TreeNode node = queue.poll();
            if (!strs[idx].equals("")) {
                node.left = new TreeNode(Integer.parseInt(strs[idx]));
                queue.offer(node.left);
            }
            
            ++idx;
            if (idx >= strs.length)
                break;
            if (!strs[idx].equals("")) {
                node.right = new TreeNode(Integer.parseInt(strs[idx]));
                queue.offer(node.right);
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
