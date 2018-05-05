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
