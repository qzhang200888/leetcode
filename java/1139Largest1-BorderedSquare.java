class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int[][][] table = new int[grid.length][grid[0].length][2];
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    table[i][j][0] = 1;
                    table[i][j][1] = 1;
                    if (j > 0) {
                        table[i][j][0] += table[i][j-1][0];
                    }
                    if (i > 0) {
                        table[i][j][1] += table[i-1][j][1];
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    int min = Math.min(table[i][j][0], table[i][j][1]);
                    while (min > max) {
                        if (table[i][j - min + 1][1] >= min && table[i  - min + 1][j][0] >= min) {
                            max = min;
                        }

                        --min;
                    }
                }
            }
        }

        return max * max;
    }
}
