/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    void closestKValues(TreeNode node, double target, int k, PriorityQueue<Integer> priorityQueue) {
        if (node == null)
            return;
        if (priorityQueue.size() < k) {
            priorityQueue.offer(node.val);
        } else {
            int top = priorityQueue.peek();
            if (Math.abs(target - top) > Math.abs(target - node.val)) {
                priorityQueue.poll();
                priorityQueue.offer(node.val);
            } else if (target - node.val < 0) {
                closestKValues(node.left, target, k, priorityQueue);
                return;
            } else {
                closestKValues(node.right, target, k, priorityQueue);
                return;
            }
        }
        
        closestKValues(node.left, target, k, priorityQueue);
        closestKValues(node.right, target, k, priorityQueue);
    }
    
    /**
     * @param root: the given BST
     * @param target: the given target
     * @param k: the given k
     * @return: k values in the BST that are closest to the target
     */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
                @Override
                public int compare(Integer f, Integer s) {
                    return (int)(Math.abs(target - s) - Math.abs(target - f));
                }
            });
            
        closestKValues(root, target, k, priorityQueue);
        
        List<Integer> res = new ArrayList<>();
        while (!priorityQueue.isEmpty())
            res.add(priorityQueue.poll());
            
        return res;
    }
}
