class Solution {    
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });
        for (int i = 0; i < heights.length - 1; ++i) {
            int diff = heights[i + 1] - heights[i];
            if (diff <= 0)
                continue;
                
            if (bricks >= diff) {
                bricks -= diff;
                pq.add(diff);
            } else if (ladders == 0) {
                return i;
            } else {
                if (!pq.isEmpty() && diff < pq.peek()) {
                    bricks += pq.poll() - diff;
                    pq.add(diff);
                }
                --ladders;
            }
        }

        return heights.length - 1;
    }
}
