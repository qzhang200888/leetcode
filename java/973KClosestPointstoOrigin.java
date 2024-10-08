class Solution {
    class Ppoint {
        public int x;
        public int y;
        public double dist;
    }
    
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Ppoint> queue = new PriorityQueue<Ppoint>(k, new Comparator<Ppoint>() {
            @Override
            public int compare(Ppoint p1, Ppoint p2) {
                return Double.compare(p2.dist, p1.dist);
            }
        });
        
        for (int[] p: points) {
            Ppoint ppt = new Ppoint();
            ppt.x = p[0];
            ppt.y = p[1];
            ppt.dist = Math.sqrt(p[0] * p[0] + p[1] * p[1]);

            queue.add(ppt);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        
        int[][] output = new int[queue.size()][2];
        for (int i = 0; i < output.length; ++i) {
            Ppoint ppt = queue.poll();
            output[i][0] = ppt.x;
            output[i][1] = ppt.y;
        }
        
        return output;
    }
}
