class Solution {
    private int lb(int[] a, int n, int x) {
        int l = 0, r = n;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (a[m] < x) l = m + 1; else r = m;
        }
        return l;
    }
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int[] xs = new int[n], ys = new int[n];
        for (int i = 0; i < n; i++) { xs[i] = points[i][0]; ys[i] = points[i][1]; }
        int[] ux = xs.clone(), uy = ys.clone();
        java.util.Arrays.sort(ux); java.util.Arrays.sort(uy);
        int mx = 0, my = 0;
        for (int i = 0; i < n; i++) { if (i == 0 || ux[i] != ux[i-1]) ux[mx++] = ux[i]; if (i == 0 || uy[i] != uy[i-1]) uy[my++] = uy[i]; }
        int[] cx = new int[n], cy = new int[n];
        for (int i = 0; i < n; i++) { cx[i] = lb(ux, mx, xs[i]) + 1; cy[i] = lb(uy, my, ys[i]) + 1; }
        int[][] pref = new int[mx + 1][my + 1];
        for (int i = 0; i < n; i++) pref[cx[i]][cy[i]]++;
        for (int i = 1; i <= mx; i++) {
            int rowSum = 0;
            for (int j = 1; j <= my; j++) {
                rowSum += pref[i][j];
                pref[i][j] = pref[i - 1][j] + rowSum;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int xi = cx[i], yi = cy[i];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (xs[i] <= xs[j] && ys[i] >= ys[j]) {
                    int x1 = xi, x2 = cx[j], y1 = yi, y2 = cy[j];
                    int cnt = pref[x2][y1] - pref[x1 - 1][y1] - pref[x2][y2 - 1] + pref[x1 - 1][y2 - 1];
                    if (cnt == 2) ans++;
                }
            }
        }
        return ans;
    }
}
