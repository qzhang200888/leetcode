class Solution {
    int[] nums;
    int[] shuffled;
    public Solution(int[] nums) {
        this.nums = new int[nums.length];
        this.shuffled =  new int[nums.length];
        
        for (int i = 0; i < nums.length; ++i) {
            this.nums = nums;
            this.shuffled[i] = nums[i];
        }
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        for (int i = 0; i < nums.length; ++i) {
            this.shuffled[i] = nums[i];
        }
        
        return shuffled;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            map.put(i, shuffled[i]);
        }
        
        int i = 0;
        Random rand = new Random();
        while (map.size() > 0) {
            List<Integer> l = new ArrayList<Integer>(map.keySet());
            int r = rand.nextInt(map.size());
            int key = l.get(r);
            shuffled[i++] = map.get(key);
            map.remove(key);
        }
        
        return shuffled;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
