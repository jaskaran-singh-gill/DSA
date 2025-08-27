class Solution {
    int[][] dirs = {{1,1}, {-1,-1}, {-1,1}, {1,-1}};
    int[] clockwise = {3,2,0,1};

    public int lenOfVDiagonal(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][][] end = new int[4][n][m];
        int[][][] fwd = new int[4][n][m];
        int ans = 0;

        for (int d = 0; d < 4; d++) {
            int dx = dirs[d][0], dy = dirs[d][1];
            int si = dx == 1 ? 0 : n - 1, ei = dx == 1 ? n : -1, stepi = dx;
            int sj = dy == 1 ? 0 : m - 1, ej = dy == 1 ? m : -1, stepj = dy;
            for (int i = si; i != ei; i += stepi) {
                for (int j = sj; j != ej; j += stepj) {
                    if (grid[i][j] == 1) end[d][i][j] = 1;
                    int pi = i - dx, pj = j - dy;
                    if (pi >= 0 && pi < n && pj >= 0 && pj < m) {
                        if (end[d][pi][pj] > 0 && grid[i][j] == nextValue(grid[pi][pj])) {
                            end[d][i][j] = Math.max(end[d][i][j], end[d][pi][pj] + 1);
                        }
                    }
                    ans = Math.max(ans, end[d][i][j]);
                }
            }
        }

        for (int d = 0; d < 4; d++) {
            int dx = dirs[d][0], dy = dirs[d][1];
            int si = dx == 1 ? n - 1 : 0, ei = dx == 1 ? -1 : n, stepi = dx == 1 ? -1 : 1;
            int sj = dy == 1 ? m - 1 : 0, ej = dy == 1 ? -1 : m, stepj = dy == 1 ? -1 : 1;
            for (int i = si; i != ei; i += stepi) {
                for (int j = sj; j != ej; j += stepj) {
                    int len = 1;
                    int ni = i + dx, nj = j + dy;
                    if (ni >= 0 && ni < n && nj >= 0 && nj < m) {
                        if (grid[ni][nj] == nextValue(grid[i][j])) {
                            len = 1 + fwd[d][ni][nj];
                        }
                    }
                    fwd[d][i][j] = len;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int d = 0; d < 4; d++) {
                    int d2 = clockwise[d];
                    if (end[d][i][j] > 0) {
                        ans = Math.max(ans, end[d][i][j] + fwd[d2][i][j] - 1);
                    }
                }
            }
        }
        return ans;
    }

    private int nextValue(int v) {
        if (v == 1) return 2;
        if (v == 2) return 0;
        return 2;
    }
}
