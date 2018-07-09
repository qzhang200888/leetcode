class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.size() == 0)
            return true;
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int room = queue.poll();
            visited[room] = true;
            for (int r: rooms.get(room)) {
                if (!visited[r])
                    queue.add(r);
            }
        }
        
        for (boolean v: visited) {
            if (!v)
                return false;
        }
        
        return true;
    }
}
