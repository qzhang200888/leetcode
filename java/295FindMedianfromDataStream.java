class MedianFinder {
    PriorityQueue<Double> upperQueue;
    PriorityQueue<Double> lowerQueue;
    /** initialize your data structure here. */
    public MedianFinder() {
        lowerQueue = new PriorityQueue<>(Collections.reverseOrder());
        upperQueue = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (upperQueue.isEmpty() || upperQueue.peek() <= num)
            upperQueue.offer((double)num);
        else
            lowerQueue.offer((double)num);
        
        if (upperQueue.size() > lowerQueue.size() + 1)
            lowerQueue.offer(upperQueue.poll());
        else if (lowerQueue.size() > upperQueue.size())
            upperQueue.offer(lowerQueue.poll());
    }
    
    public double findMedian() {
        if (upperQueue.size() > lowerQueue.size())
            return upperQueue.peek();
        return (upperQueue.peek() + lowerQueue.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

============================

class MedianFinder {
    class TreeNode {
        public double val;
        public TreeNode left, right;
        public TreeNode(double val) {
            this.val = val;
            left = right = null;
        }
    
        public void insert(double val) {
            if (val >= this.val) {
                if (right == null)
                    right = new TreeNode(val);
                else right.insert(val);
            } else {
                if (left == null)
                    left = new TreeNode(val);
                else left.insert(val);
            }
        }
    }
    
    int balance;
    TreeNode root;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        balance = 0;
        root = null;
    }
    
    public void addNum(int num) {
        if (root == null) {
            root = new TreeNode(num);
            root.right = new TreeNode(num);
            balance = 1;
            return;
        }
        
        if (num >= root.val) {
            ++balance;       
        } else {
            --balance;
        }
        
        root.insert(num);
        
        if (balance > 1) {
            TreeNode n = root.right;
            if (n.left == null) {
                root.right = n.right;
            } else {
                while (n.left.left != null)
                    n = n.left;
                TreeNode temp = n;
                n = n.left;
                temp.left = n.right;
            }
            
            if (root.left == null)
                root.left = new TreeNode(n.val);
            else root.left.insert(n.val);
            balance -= 2;
        } else if (balance < -1) {
            TreeNode n = root.left;
            if (n.right == null) {
                root.left = n.left;
            } else {
                while (n.right.right != null)
                    n = n.right;
                TreeNode temp = n;
                n = n.right;
                temp.right = n.left;
            }
            
            if (root.right == null)
                root.right = new TreeNode(n.val);
            else root.right.insert(n.val);
            balance += 2;
        }
        
        double leftMax = 0, rightMin = 0;
        if (balance >= 0) {
            TreeNode n = root.right;
            while (n.left != null)
                n = n.left;
            rightMin = n.val;
        }
        
        if (balance <= 0) {
            TreeNode n = root.left;
            while (n.right != null)
                n = n.right;
            leftMax = n.val;
        }
        
        if (balance > 0)
            root.val = rightMin;
        else if (balance < 0)
            root.val = leftMax;
        else root.val = (leftMax + rightMin) / 2;
    }
    
    public double findMedian() {
        if (root == null)
            return 0;
        return root.val;
    }
}

// using heap

class MedianFinder {
    PriorityQueue<Integer> minQ;
    PriorityQueue<Integer> maxQ;
    /** initialize your data structure here. */
    public MedianFinder() {
        minQ = new PriorityQueue<Integer>();
        maxQ = new PriorityQueue<Integer>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if (minQ.size() == 0) {
            minQ.offer(num);
            return;
        }
        
        int max = minQ.peek();
        if (num > max)
            minQ.offer(num);
        else maxQ.offer(num);

        if (maxQ.size() > minQ.size())
            minQ.offer(maxQ.poll());
        else if (maxQ.size() + 1 < minQ.size())
            maxQ.offer(minQ.poll());
    }
    
    public double findMedian() {
        if (minQ.size() > maxQ.size())
            return minQ.peek();
        
        return (minQ.peek() + maxQ.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
