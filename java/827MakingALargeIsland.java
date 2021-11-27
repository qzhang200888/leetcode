
class Solution {    
    public int largestIsland(int[][] grid) {
        int group = 2;
        List<Integer> lst = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    int ar = area(grid, i, j, group);
                    if (ar > max)
                        max = ar;
                    lst.add(ar);
                    ++group;
                }
            }
        }
        
        if (max == grid.length * grid[0].length)
            return max;
        
        ++max;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] != 0)
                    continue;
                int ar = 1;
                List<Integer> nlst = new ArrayList<>();
                if (i > 0 && grid[i-1][j] != 0) {
                    addUnique(nlst, grid[i-1][j]);
                }
                if (j > 0 && grid[i][j-1] != 0) {
                    addUnique(nlst, grid[i][j-1]);
                }
                if (i < grid.length - 1 && grid[i+1][j] != 0) {
                    addUnique(nlst, grid[i+1][j]);
                }
                if (j< grid[0].length - 1 && grid[i][j+1] != 0) {
                    addUnique(nlst, grid[i][j + 1]);
                }
                
                if (nlst.size() > 1) {
                    for(int g: nlst) {
                        ar += lst.get(g - 2);
                    }
                    if (max < ar) {
                        max = ar;
                    }
                }
            }
        }
        
        return max;
    }
    
    int area(int[][] grid, int r, int c, int group) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length)
            return 0;

        if (grid[r][c] != 1)
            return 0;

        grid[r][c] = group;
        int a = 1;
        a += area(grid, r - 1, c, group);
        a += area(grid, r + 1, c, group);
        a += area(grid, r, c - 1, group);
        a += area(grid, r, c + 1, group);
        
        return a;
    }
    
    void addUnique(List<Integer> lst, int v) {
        for (int i: lst) {
            if (i == v)
                return;
        }
        lst.add(v);
    }
}


=============================================================================

class Solution {    
    public int largestIsland(int[][] grid) {
        int group = 2;
        List<Integer> lst = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    int ar = area(grid, i, j, group);
                    if (ar > max)
                        max = ar;
                    lst.add(ar);
                    ++group;
                }
            }
        }
        
        if (max == grid.length * grid[0].length)
            return max;
        
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] != 0)
                    continue;
                int group1 = -1, group2 = -1, group3 = -1;
                int ar = 1;
                if (i > 0 && grid[i-1][j] != 0) {
                    group1 = grid[i-1][j];
                    ar += lst.get(grid[i-1][j] - 2);
                }
                if (j > 0 && grid[i][j-1] != 0) {
                    if (group1 < 0) {
                        group1 = grid[i][j - 1];
                        ar += lst.get(grid[i][j-1] - 2);
                    } else if (grid[i][j - 1] != group1) {
                        group2 = grid[i][j - 1];
                        ar += lst.get(grid[i][j-1] - 2);
                    }
                }

                if (i < grid.length - 1 && grid[i+1][j] != 0) {
                    if (group1 < 0) {
                        group1 = grid[i + 1][j];
                        ar += lst.get(grid[i+1][j] - 2);
                    } else if (group2 < 0 && grid[i+1][j] != group1) {
                        group2 = grid[i+1][j ];
                        ar += lst.get(grid[i+1][j] - 2);
                    } else if (group1 > 0 && group2 > 0 && grid[i+1][j] != group1 && grid[i+1][j] != group2) {
                        group3 = grid[i+1][j];
                        ar += lst.get(grid[i+1][j] - 2);
                    }
                }

                if (j< grid[0].length - 1 && grid[i][j+1] != 0) {
                    if (group1 < 0) {
                        ar += lst.get(grid[i][j+1] - 2);
                    } else if (group2 < 0 && grid[i][j+1] != group1) {
                        ar += lst.get(grid[i][j+1] - 2);
                    } else if (group1 > 0 && group2 > 0 && group3 < 0 && grid[i][j+1] != group1 && grid[i][j+1] != group2) {
                        ar += lst.get(grid[i][j+1] - 2);
                    } else if (group1 > 0 && group2 > 0 && group3 > 0 && grid[i][j+1] != group1 && grid[i][j+1] != group2 && grid[i][j+1] != group3) {
                        ar += lst.get(grid[i][j+1] - 2);
                    }
                }
                
                if (max < ar) {
                    max = ar;
                }
            }
        }
        
        return max;
    }
    
    int area(int[][] grid, int r, int c, int group) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length)
            return 0;

        if (grid[r][c] != 1)
            return 0;

        grid[r][c] = group;
        int a = 1;
        a += area(grid, r - 1, c, group);
        a += area(grid, r + 1, c, group);
        a += area(grid, r, c - 1, group);
        a += area(grid, r, c + 1, group);
        
        return a;
    }
}

======================================================================
class Solution {
    boolean isCandidate(int[][] grid, int r, int c) {
        if (grid[r][c] != 0)
            return false;
        int count = 0;
        if (r > 0 && grid[r-1][c] == 1)
            ++count;
        if (c > 0 && grid[r][c-1] == 1)
            ++count;
        
        if (r < grid.length - 1 && grid[r+1][c] == 1)
            ++count;
        if (c < grid[0].length - 1 && grid[r][c+1] == 1)
            ++count;
        
        return count > 1;
    }
    
    int area(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length)
            return 0;
        if (grid[r][c] != 1)
            return 0;
        
        grid[r][c] = -1;
        int count = 1;
        count += area(grid, r - 1, c);
        count += area(grid, r + 1, c);
        count += area(grid, r, c - 1);
        count += area(grid, r, c + 1);
        
        return count;
    }
    
    void restore(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length)
            return;
        if (grid[r][c] != -1)
            return;
        
        grid[r][c] = 1;
        restore(grid, r - 1, c);
        restore(grid, r + 1, c);
        restore(grid, r, c - 1);
        restore(grid, r, c + 1);
    }
    
    public int largestIsland(int[][] grid) {
        List<int[]> candidates = new ArrayList<>();
        boolean foundZero = false;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (isCandidate(grid, i, j))
                    candidates.add(new int[]{i, j});
                if (grid[i][j] == 0)
                    foundZero = true;
            } 
        }
        
        if (candidates.isEmpty()) {
            int ar = maxAreaOfIsland(grid);
            if (foundZero)
                ++ar;
            return ar;
        }
        
        int max = 0;
        for (int[] pos: candidates) {
            int i = pos[0];
            int j = pos[1];
            int ar = area(grid, i+1, j) + 1;
            ar += area(grid, i-1, j);
            ar += area(grid, i, j - 1);
            ar += area(grid, i, j + 1);
            
            if (ar > max)
                max = ar;
            restore(grid, i+1, j);
            restore(grid, i-1, j);
            restore(grid, i, j - 1);
            restore(grid, i, j + 1);
        }
        
        return max;
    }
    
    int getArea(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length)
            return 0;

        if (grid[r][c] == 0)
            return 0;
        grid[r][c] = 0;
        int a = 1;
        a += area(grid, r - 1, c);
        a += area(grid, r + 1, c);
        a += area(grid, r, c - 1);
        a += area(grid, r, c + 1);
        
        return a;
    }
    
    int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                int a = getArea(grid, i, j);
                if (max < a)
                    max = a;
            }
        }
        
        return max;
    }
}
