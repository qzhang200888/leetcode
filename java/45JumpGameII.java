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

============================================================

class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] steps = new int[nums.length];
        for (int i = 1; i < nums.length; ++i)
            steps[i] = nums.length;

        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = 1; j <= nums[i] && i + j < nums.length; ++j) {
                steps[i + j] = Math.min(steps[i + j], steps[i] + 1);
            }   
        }
        
        return steps[nums.length - 1];
        
    }
}

=================================================================

class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        int[] res = new int[nums.length];
        res[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; --i) {
            int min = Integer.MAX_VALUE;
            for (int j = i + 1; j <= i + nums[i] && j < nums.length; ++j) {
                min= Math.min(min, res[j]);
            }

            if (min < Integer.MAX_VALUE) {
                res[i] = min + 1;
            } else {
                res[i] = Integer.MAX_VALUE;
            }
        }

        return res[0];
    }
}
