class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length, res = 0;
        int[] dp = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int prev = 0;
            char[] row = matrix[i];
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                if (row[j - 1] == '1') {
                    int v = dp[j] < dp[j - 1] ? dp[j] : dp[j - 1];
                    v = v < prev ? v : prev;
                    v++;
                    dp[j] = v;
                    if (v > res) res = v;
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return res * res;
    }
}
