class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1)
            return 0;
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.offer(0);
        set.add(0);
        int steps = 0;
        while (!queue.isEmpty()) {
            ++steps;
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int pos = queue.poll();
                
                if (pos + nums[pos] >= nums.length - 1)
                    return steps;
                
                for (int j = nums[pos]; j > 0; --j) {
                    if (!set.contains(pos + j)) {
                        queue.offer(pos + j);
                        set.add(pos + j);
                    }
                }
            }
        }
        
        return 0;
    }
}
