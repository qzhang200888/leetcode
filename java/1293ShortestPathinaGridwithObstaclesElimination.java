class Solution {
    class Pos {
        public int row;
        public int col; 
        public int energy;
        
        public Pos(int row, int col, int energy) {
            this.row = row;
            this.col = col;
            this.energy = energy;
        }
    }
    
    List<Pos> getNeighbors(int[][] grid, Pos p, int[][] visited) {
        int row = p.row;
        int col = p.col;
        List<Pos> res = new ArrayList<>();
        if (row > 0) {
            int energy = p.energy;
            if (grid[row - 1][col] > 0)
                --energy;
            if (energy > visited[row - 1][col]) {
                res.add(new Pos(row - 1, col, energy));
                visited[row - 1][col] = energy;
            }
        }
        
        if (row < grid.length - 1) {
            int energy = p.energy;
            if (grid[row + 1][col] > 0)
                --energy;
            if (energy > visited[row + 1][col]) {
                res.add(new Pos(row + 1, col, energy));
                visited[row + 1][col] = energy;
            }
        }
        
        if (col > 0) {
            int energy = p.energy;
            if (grid[row][col - 1] > 0)
                --energy;
            if (energy > visited[row][col - 1]) {
                res.add(new Pos(row, col - 1, energy));
                visited[row][col - 1] = energy;
            }
        }
        
        if (col < grid[0].length - 1) {
            int energy = p.energy;
            if (grid[row][col + 1] > 0)
                --energy;
            if (energy > visited[row][col + 1]) {
                res.add(new Pos(row, col + 1, energy));
                visited[row][col + 1] = energy;
            }
        }
        
        return res;
    }

    public int shortestPath(int[][] grid, int k) {
        int[][] visited = new int[grid.length][grid[0].length];
        for (int[] rowArr: visited)
            Arrays.fill(rowArr, -1);
        Queue<Pos> queue = new LinkedList<>();
        Pos p = new Pos(0, 0, k);
        queue.add(p);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                p = queue.poll();
                if (p.row == grid.length - 1 && p.col == grid[0].length - 1)
                    return step;
                queue.addAll(getNeighbors(grid, p, visited));
            }
            
            ++step;
        }
        
        return -1;
    }
}
