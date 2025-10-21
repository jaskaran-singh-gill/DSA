class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 2][n + 2];
        for (int len = 2; len <= n; len++) {
            for (int l = 1; l + len - 1 <= n; l++) {
                int r = l + len - 1;
                int best = Integer.MAX_VALUE;
                for (int x = (l + r) / 2; x <= r; x++) {
                    int cost = x + Math.max(dp[l][x - 1], dp[x + 1][r]);
                    if (cost < best) best = cost;
                }
                dp[l][r] = best;
            }
        }
        return dp[1][n];
    }
}
