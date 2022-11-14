class Solution {
public:
    int largest1BorderedSquare(vector<vector<int>>& grid) {
        vector<vector<int>> horizon(grid.size(), vector<int>(grid[0].size(), 0));
        vector<vector<int>> vertical(grid.size(), vector<int>(grid[0].size(), 0));

        int max = 0;
        for (int i = 0; i < grid.size(); ++i) {
            for (int j = 0; j < grid[0].size(); ++j) {
                if (grid[i][j] == 1) {
                    vertical[i][j] = 1;
                    horizon[i][j] = 1;
                    if (j > 0) {
                        horizon[i][j] += horizon[i][j-1];
                    }
                    if (i > 0) {
                        vertical[i][j] += vertical[i-1][j];
                    }
                    int len = horizon[i][j];
                    if (len > vertical[i][j]) {
                        len = vertical[i][j];
                    }

                    while (len > max) {
                        if (vertical[i][j - len + 1] >= len && horizon[i - len + 1][j] >= len) {
                            max = len;
                        }
                        --len;
                    }
                }
            }
        }

        return max * max;
    }
};

=================================================================================

class Solution {
public:
    int largest1BorderedSquare(vector<vector<int>>& grid) {
        vector<vector<int>> horizon(grid.size(), vector<int>(grid[0].size(), 0));
        vector<vector<int>> vertical(grid.size(), vector<int>(grid[0].size(), 0));

        for (int i = 0; i < grid.size(); ++i) {
            for (int j = 0; j < grid[0].size(); ++j) {
                if (grid[i][j] == 1) {
                    horizon[i][j] = 1;
                    vertical[i][j] = 1;
                    if (i > 0) {
                        vertical[i][j] += vertical[i-1][j];
                    }
                    if (j > 0) {
                        horizon[i][j] += horizon[i][j-1];
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < grid.size(); ++i) {
            for (int j = 0; j < grid[0].size(); ++j) {
                if (grid[i][j] == 1) {
                    int len = horizon[i][j];
                    if (len > vertical[i][j]) {
                        len = vertical[i][j];
                    }

                    while (len > max) {
                        if (vertical[i][j - len + 1] >= len && horizon[i - len + 1][j] >= len) {
                            max = len;
                        }
                        --len;
                    }
                }
            }
        }

        return max * max;
    }
};

