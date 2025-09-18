class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length, N = n * m;
        int[] out = new int[N];
        int[] q = new int[N];
        int h = 0, t = 0;
        int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
        for (int i = 0; i < n; i++) {
            int base = i * m;
            for (int j = 0; j < m; j++) {
                int u = base + j, v = matrix[i][j], c = 0;
                if (i > 0 && matrix[i - 1][j] > v) c++;
                if (i + 1 < n && matrix[i + 1][j] > v) c++;
                if (j > 0 && matrix[i][j - 1] > v) c++;
                if (j + 1 < m && matrix[i][j + 1] > v) c++;
                out[u] = c;
            }
        }
        for (int u = 0; u < N; u++) if (out[u] == 0) q[t++] = u;
        int ans = 0;
        while (h < t) {
            int sz = t - h;
            ans++;
            while (sz-- > 0) {
                int u = q[h++], i = u / m, j = u % m, v = matrix[i][j];
                if (i > 0 && matrix[i - 1][j] < v && --out[(i - 1) * m + j] == 0) q[t++] = (i - 1) * m + j;
                if (i + 1 < n && matrix[i + 1][j] < v && --out[(i + 1) * m + j] == 0) q[t++] = (i + 1) * m + j;
                if (j > 0 && matrix[i][j - 1] < v && --out[i * m + (j - 1)] == 0) q[t++] = i * m + (j - 1);
                if (j + 1 < m && matrix[i][j + 1] < v && --out[i * m + (j + 1)] == 0) q[t++] = i * m + (j + 1);
            }
        }
        return ans;
    }
}
