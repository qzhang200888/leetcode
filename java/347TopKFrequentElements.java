class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return map.get(i1) - map.get(i2);
            }
        });
        
        for (int key: map.keySet()) {
            if (pq.size() < k)
                pq.offer(key);
            else if (map.get(key) > map.get(pq.peek())) {
                pq.poll();
                pq.offer(key);
            }
        }
        
        List<Integer> res = new LinkedList<>();
        while (!pq.isEmpty())
            res.add(pq.poll());
        
        return res;
    }
}
