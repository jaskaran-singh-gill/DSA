class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        for (int len = 2; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                int j = i + len, best = Integer.MAX_VALUE, vi = values[i], vj = values[j];
                for (int k = i + 1; k < j; k++) {
                    int t = dp[i][k] + dp[k][j] + vi * vj * values[k];
                    if (t < best) best = t;
                }
                dp[i][j] = best;
            }
        }
        return dp[0][n - 1];
    }
}
