class Solution {
    public double soupServings(int n) {
        if (n >= 4800) return 1.0;
        int m = (n + 24) / 25;
        double[][] dp = new double[m + 1][m + 1];
        for (int i = 0; i <= m; i++) java.util.Arrays.fill(dp[i], -1.0);
        return dfs(m, m, dp);
    }
    private double dfs(int a, int b, double[][] dp) {
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1.0;
        if (b <= 0) return 0.0;
        if (dp[a][b] >= 0) return dp[a][b];
        dp[a][b] = 0.25 * (dfs(a - 4, b, dp) + dfs(a - 3, b - 1, dp) + dfs(a - 2, b - 2, dp) + dfs(a - 1, b - 3, dp));
        return dp[a][b];
    }
}
