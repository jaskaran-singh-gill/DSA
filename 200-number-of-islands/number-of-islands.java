class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length, ans = 0;
        int[] q = new int[m * n];
        for (int i = 0; i < m; i++) {
            char[] row = grid[i];
            for (int j = 0; j < n; j++) {
                if (row[j] != '1') continue;
                ans++;
                row[j] = '0';
                int head = 0, tail = 0;
                q[tail++] = i * n + j;
                while (head < tail) {
                    int p = q[head++], r = p / n, c = p % n;
                    int nr = r - 1, nc = c;
                    if (nr >= 0 && grid[nr][nc] == '1') { grid[nr][nc] = '0'; q[tail++] = nr * n + nc; }
                    nr = r + 1; nc = c;
                    if (nr < m && grid[nr][nc] == '1') { grid[nr][nc] = '0'; q[tail++] = nr * n + nc; }
                    nr = r; nc = c - 1;
                    if (nc >= 0 && grid[nr][nc] == '1') { grid[nr][nc] = '0'; q[tail++] = nr * n + nc; }
                    nr = r; nc = c + 1;
                    if (nc < n && grid[nr][nc] == '1') { grid[nr][nc] = '0'; q[tail++] = nr * n + nc; }
                }
            }
        }
        return ans;
    }
}
