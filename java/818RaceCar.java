class Solution {
    public int racecar(int target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 1, 0});
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            if (arr[0] == target)
                return arr[2];

            queue.add(new int[] {arr[0] + arr[1], 2 * arr[1], arr[2] + 1});
            
            if (target < arr[0] + arr[1] && arr[1] > 0)
                queue.add(new int[] {arr[0], -1, arr[2] + 1});
            else if (target > arr[0] + arr[1] && arr[1] < 0)
                queue.add(new int[] {arr[0], 1, arr[2] + 1});
        }
        
        return -1;
    }
}
