class Solution {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0)
            return true;
        if (stones[0] != 0)
            return false;
        
        Set<Integer>[] steps = new Set[stones.length];
        steps[0] = new HashSet<Integer>();
        steps[0].add(0);
        
        for (int i = 1; i < stones.length; ++i) {
            steps[i] = new HashSet<Integer>();
            for (int j = i - 1; j >= 0; --j) {
                int jump = stones[i] - stones[j];
                if (steps[j].contains(jump - 1) || steps[j].contains(jump) || steps[j].contains(jump + 1)) {
                    if (i == stones.length - 1)
                        return true;
                    steps[i].add(jump);
                }
            }
        }
        
        return false;
    }
}

// faster
class Solution {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0)
            return true;
        if (stones[0] != 0)
            return false;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < stones.length; ++i) {
            map.put(stones[i], i);
        }
        
        Set<Integer>[] steps = new Set[stones.length];
        steps[0] = new HashSet<Integer>();
        steps[0].add(0);

        for (int i = 0; i < stones.length; ++i) {
            if (steps[i] == null)
                continue;
            for (int s: steps[i]) {
                for (int k = s - 1; k <= s + 1; ++k) {
                    if (k > 0 && map.containsKey(stones[i] + k)) {
                        int index = map.get(stones[i] + k);
                        if (index == stones.length - 1)
                            return true;
                        if (steps[index] == null)
                            steps[index] = new HashSet<>();
                        steps[index].add(k);
                    }
                }
            }
        }

        return false;
    }
}
