class Solution {
    class Node {
        public int row;
        public int col;
        public int effort;
        public Node(int row, int col, int effort) {
            this.row = row;
            this.col = col;
            this.effort = effort;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int[][] costs = new int[heights.length][heights[0].length];
        for (int[] row: costs) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        PriorityQueue<Node> queue = new PriorityQueue<>(heights.length + heights[0].length, new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return n1.effort - n2.effort;
            }
        });
        queue.add(new Node(0, 0, 0));
        costs[0][0] = 0;
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            if (n.row == heights.length - 1 && n.col == heights[0].length - 1) {
                return n.effort;
            }
            if (n.row > 0 && costs[n.row - 1][n.col] > Math.max(n.effort, Math.abs(heights[n.row][n.col] - heights[n.row - 1][n.col]))) {
                queue.add(new Node(n.row - 1, n.col, Math.max(n.effort, Math.abs(heights[n.row][n.col] - heights[n.row - 1][n.col]))));
                costs[n.row - 1][n.col] = Math.max(n.effort, Math.abs(heights[n.row][n.col] - heights[n.row - 1][n.col]));
            }
            
            if (n.row < heights.length - 1 && costs[n.row + 1][n.col] > Math.max(n.effort, Math.abs(heights[n.row][n.col] - heights[n.row + 1][n.col]))) {
                queue.add(new Node(n.row + 1, n.col, Math.max(n.effort, Math.abs(heights[n.row][n.col] - heights[n.row + 1][n.col]))));
                costs[n.row + 1][n.col] = Math.max(n.effort, Math.abs(heights[n.row][n.col] - heights[n.row + 1][n.col]));
            }
            
            if (n.col > 0 && costs[n.row][n.col - 1] > Math.max(n.effort, Math.abs(heights[n.row][n.col] - heights[n.row][n.col - 1]))) {
                queue.add(new Node(n.row, n.col - 1, Math.max(n.effort, Math.abs(heights[n.row][n.col] - heights[n.row][n.col - 1]))));
                costs[n.row][n.col - 1] = Math.max(n.effort, Math.abs(heights[n.row][n.col] - heights[n.row][n.col - 1]));
            }
            
            if (n.col < heights[0].length - 1 && costs[n.row][n.col + 1] > Math.max(n.effort, Math.abs(heights[n.row][n.col] - heights[n.row][n.col + 1]))) {
                queue.add(new Node(n.row, n.col + 1, Math.max(n.effort, Math.abs(heights[n.row][n.col] - heights[n.row][n.col + 1]))));
                costs[n.row][n.col + 1] = Math.max(n.effort, Math.abs(heights[n.row][n.col] - heights[n.row][n.col + 1]));
            }
        }
        
        return costs[costs.length - 1][costs[0].length - 1];
    }
}

========================================================================

class Solution {
    class Node {
        public int row;
        public int col;
        public int effort;
        public Node(int row, int col, int effort) {
            this.row = row;
            this.col = col;
            this.effort = effort;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int[][] costs = new int[heights.length][heights[0].length];
        for (int[] row: costs) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 0));
        costs[0][0] = 0;
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            if (n.row > 0 && costs[n.row - 1][n.col] > Math.max(n.effort, Math.abs(heights[n.row][n.col] - heights[n.row - 1][n.col]))) {
                queue.add(new Node(n.row - 1, n.col, Math.max(n.effort, Math.abs(heights[n.row][n.col] - heights[n.row - 1][n.col]))));
                costs[n.row - 1][n.col] = Math.max(n.effort, Math.abs(heights[n.row][n.col] - heights[n.row - 1][n.col]));
            }
            
            if (n.row < heights.length - 1 && costs[n.row + 1][n.col] > Math.max(n.effort, Math.abs(heights[n.row][n.col] - heights[n.row + 1][n.col]))) {
                queue.add(new Node(n.row + 1, n.col, Math.max(n.effort, Math.abs(heights[n.row][n.col] - heights[n.row + 1][n.col]))));
                costs[n.row + 1][n.col] = Math.max(n.effort, Math.abs(heights[n.row][n.col] - heights[n.row + 1][n.col]));
            }
            
            if (n.col > 0 && costs[n.row][n.col - 1] > Math.max(n.effort, Math.abs(heights[n.row][n.col] - heights[n.row][n.col - 1]))) {
                queue.add(new Node(n.row, n.col - 1, Math.max(n.effort, Math.abs(heights[n.row][n.col] - heights[n.row][n.col - 1]))));
                costs[n.row][n.col - 1] = Math.max(n.effort, Math.abs(heights[n.row][n.col] - heights[n.row][n.col - 1]));
            }
            
            if (n.col < heights[0].length - 1 && costs[n.row][n.col + 1] > Math.max(n.effort, Math.abs(heights[n.row][n.col] - heights[n.row][n.col + 1]))) {
                queue.add(new Node(n.row, n.col + 1, Math.max(n.effort, Math.abs(heights[n.row][n.col] - heights[n.row][n.col + 1]))));
                costs[n.row][n.col + 1] = Math.max(n.effort, Math.abs(heights[n.row][n.col] - heights[n.row][n.col + 1]));
            }
        }
        
        return costs[costs.length - 1][costs[0].length - 1];
    }
}
