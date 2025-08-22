class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int INF = 1 << 29;
        int[] dp = new int[n + 1];
        for (int j = 0; j <= n; j++) dp[j] = INF;
        dp[n - 1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int minNext = dp[j + 1] < dp[j] ? dp[j + 1] : dp[j];
                int need = minNext - dungeon[i][j];
                dp[j] = need > 1 ? need : 1;
            }
        }
        return dp[0];
    }
}
