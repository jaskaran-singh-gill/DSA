class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        int[] row = grid[0];
        dp[0] = row[0];
        for (int j = 1; j < n; j++) dp[j] = dp[j - 1] + row[j];
        for (int i = 1; i < m; i++) {
            row = grid[i];
            dp[0] += row[0];
            for (int j = 1; j < n; j++) {
                int a = dp[j], b = dp[j - 1];
                dp[j] = (a < b ? a : b) + row[j];
            }
        }
        return dp[n - 1];
    }
}
