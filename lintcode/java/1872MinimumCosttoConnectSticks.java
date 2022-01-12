public class Solution {
    /**
     * @param sticks: the length of sticks
     * @return: Minimum Cost to Connect Sticks
     */
    public int MinimumCost(List<Integer> sticks) {
        // write your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int st: sticks) {
            pq.add(st);
        }

        int total = 0;
        while (pq.size() > 1) {
            int cost = pq.poll();
            cost += pq.poll();
            total += cost;
            pq.add(cost);
        }

        return total;
    }
}
