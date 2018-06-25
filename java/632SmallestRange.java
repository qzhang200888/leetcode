class Solution {
    class NumIndex {
        public int row;
        public int col;
        
        public NumIndex(int row, int col) {
            this.row = row;
            this.col = col;        
        }
    }
    
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<NumIndex> pq = new PriorityQueue<NumIndex>(10, new Comparator<NumIndex>() {
            @Override
            public int compare(NumIndex ni1, NumIndex ni2) {
                return nums.get(ni1.row).get(ni1.col) - nums.get(ni2.row).get(ni2.col);
            }
        });
                
        int row = 0, max = Integer.MIN_VALUE;
        for (List<Integer> lst: nums) {
            int val = nums.get(row).get(0);
            if (val > max)
                max = val;
            pq.add(new NumIndex(row++, 0));
        }
        
        NumIndex ni = pq.poll();
        int start = nums.get(ni.row).get(ni.col), end = max;
        int min_length = end - start;
                
        while (ni.col < nums.get(ni.row).size() - 1) {
            NumIndex newIndex = new NumIndex(ni.row, ni.col + 1);
            pq.add(newIndex);
            max = Math.max(max, nums.get(newIndex.row).get(newIndex.col));
            
            ni = pq.poll();
            if (max - nums.get(ni.row).get(ni.col) < min_length) {
                min_length = max - nums.get(ni.row).get(ni.col);
                start = nums.get(ni.row).get(ni.col);
                end = max;
            }
        }
                
        return new int[]{start, end};
    }
}
