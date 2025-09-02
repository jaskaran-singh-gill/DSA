class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length, m = 52, res = 0;
        int[][] pref = new int[m][m];
        for (int[] p : points) pref[p[0] + 1][p[1] + 1]++;
        for (int i = 1; i < m; i++) for (int j = 1; j < m; j++) pref[i][j] += pref[i - 1][j] + pref[i][j - 1] - pref[i - 1][j - 1];
        for (int i = 0; i < n; i++) {
            int x1 = points[i][0], y1 = points[i][1];
            for (int j = 0; j < n; j++) if (i != j) {
                int x2 = points[j][0], y2 = points[j][1];
                if (x1 <= x2 && y1 >= y2) {
                    int X1 = x1 + 1, X2 = x2 + 1, Y1 = y1 + 1, Y2 = y2 + 1;
                    int cnt = pref[X2][Y1] - pref[X1 - 1][Y1] - pref[X2][Y2 - 1] + pref[X1 - 1][Y2 - 1];
                    if (cnt == 2) res++;
                }
            }
        }
        return res;
    }
}
