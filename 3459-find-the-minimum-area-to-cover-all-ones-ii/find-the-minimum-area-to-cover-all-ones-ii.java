class Solution {
    int m,n;
    int[][] rowPS;
    int[][] colPS;
    public int minimumSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        rowPS = new int[m][n + 1];
        colPS = new int[n][m + 1];
        for (int i = 0; i < m; i++) {
            int[] r = rowPS[i];
            int s = 0;
            for (int j = 0; j < n; j++) {
                s += grid[i][j];
                r[j + 1] = s;
                colPS[j][i + 1] = colPS[j][i] + grid[i][j];
            }
        }
        int ans = m * n;
        for (int i = 0; i < m; i++) {
            int top = area(0, i, 0, n - 1);
            for (int j = 0; j < n; j++) {
                int a = area(i + 1, m - 1, 0, j);
                int b = area(i + 1, m - 1, j + 1, n - 1);
                int s = top + a + b;
                if (s < ans) ans = s;
            }
        }
        for (int i = 0; i < m; i++) {
            int bottom = area(i, m - 1, 0, n - 1);
            for (int j = 0; j < n; j++) {
                int a = area(0, i - 1, 0, j);
                int b = area(0, i - 1, j + 1, n - 1);
                int s = bottom + a + b;
                if (s < ans) ans = s;
            }
        }
        for (int j = 0; j < n; j++) {
            int left = area(0, m - 1, 0, j);
            for (int i = 0; i < m; i++) {
                int a = area(0, i, j + 1, n - 1);
                int b = area(i + 1, m - 1, j + 1, n - 1);
                int s = left + a + b;
                if (s < ans) ans = s;
            }
        }
        for (int j = 0; j < n; j++) {
            int right = area(0, m - 1, j, n - 1);
            for (int i = 0; i < m; i++) {
                int a = area(0, i, 0, j - 1);
                int b = area(i + 1, m - 1, 0, j - 1);
                int s = right + a + b;
                if (s < ans) ans = s;
            }
        }
        for (int i1 = 0; i1 < m; i1++) {
            for (int i2 = i1 + 1; i2 < m; i2++) {
                int s = area(0, i1, 0, n - 1) + area(i1 + 1, i2, 0, n - 1) + area(i2 + 1, m - 1, 0, n - 1);
                if (s < ans) ans = s;
            }
        }
        for (int j1 = 0; j1 < n; j1++) {
            for (int j2 = j1 + 1; j2 < n; j2++) {
                int s = area(0, m - 1, 0, j1) + area(0, m - 1, j1 + 1, j2) + area(0, m - 1, j2 + 1, n - 1);
                if (s < ans) ans = s;
            }
        }
        return ans;
    }
    private int area(int si, int ei, int sj, int ej) {
        if (si > ei || sj > ej) return 0;
        int top = -1;
        for (int i = si; i <= ei; i++) {
            if (rowPS[i][ej + 1] - rowPS[i][sj] > 0) { top = i; break; }
        }
        if (top == -1) return 0;
        int bottom = -1;
        for (int i = ei; i >= si; i--) {
            if (rowPS[i][ej + 1] - rowPS[i][sj] > 0) { bottom = i; break; }
        }
        int left = -1;
        for (int j = sj; j <= ej; j++) {
            if (colPS[j][bottom + 1] - colPS[j][top] > 0) { left = j; break; }
        }
        int right = -1;
        for (int j = ej; j >= sj; j--) {
            if (colPS[j][bottom + 1] - colPS[j][top] > 0) { right = j; break; }
        }
        return (bottom - top + 1) * (right - left + 1);
    }
}
