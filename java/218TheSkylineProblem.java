class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<int[]>();
        if (buildings == null)
            return res;
        
        List<int[]> starts = new ArrayList<int[]>();
        List<int[]> ends = new ArrayList<int[]>();
        for (int i = 0; i < buildings.length; ++i) {
            int[] start = new int[2];
            int[] end = new int[2];
            start[0] = buildings[i][0];
            start[1] = buildings[i][2];
            end[0] = buildings[i][1];
            end[1] = buildings[i][2];
            
            starts.add(start);
            ends.add(end);
        }
        
        Comparator comp = new Comparator<int[]>() {
            @Override
            public int compare(int[] first, int[] second) {
                return first[0] - second[0];
            }
        };
        
        Collections.sort(starts, comp);
        Collections.sort(ends, comp);
        
        PriorityQueue<Integer> pq = new PriorityQueue(10, Collections.reverseOrder());
        
        int i = 0, j = 0;
        int prevH = 0;
        while (i < starts.size() && j < ends.size()) {
            int pos = starts.get(i)[0];
            if (pos <= ends.get(j)[0]) {
                while (i < starts.size() && pos == starts.get(i)[0]) {
                    pq.add(starts.get(i)[1]);
                    ++i;
                }
            }
            
            if (pos >= ends.get(j)[0]) {
                pos = ends.get(j)[0];
                while (j < starts.size() && pos == ends.get(j)[0]) {
                    pq.remove(ends.get(j)[1]);
                    ++j;
                }
            }
            
            int height = 0;
            if (!pq.isEmpty()) {
                height = pq.peek();
            }
            if (height != prevH) {
                prevH = height;
                res.add(new int[] {pos, height});
            }
        }
        
        while (j < ends.size()) {
            int pos = ends.get(j)[0];
            while (j < starts.size() && pos == ends.get(j)[0]) {
                pq.remove(ends.get(j)[1]);
                ++j;
            }
            
            int height = 0;
            if (!pq.isEmpty()) {
                height = pq.peek();
            }
            if (height != prevH) {
                prevH = height;
                res.add(new int[] {pos, height});
            }
        }
        
        return res;
    }
}
