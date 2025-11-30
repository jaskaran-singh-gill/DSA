class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] val = new int[n + 2];
        int m = 1;
        for (int x : nums) if (x > 0) val[m++] = x;
        val[0] = 1;
        val[m] = 1;
        int[][] dp = new int[m + 1][m + 1];
        for (int len = 2; len <= m; len++) {
            for (int left = 0; left + len <= m; left++) {
                int right = left + len;
                int best = 0;
                int lv = val[left], rv = val[right];
                int[] dpLeft = dp[left];
                for (int k = left + 1; k < right; k++) {
                    int candidate = dpLeft[k] + dp[k][right] + lv * val[k] * rv;
                    if (candidate > best) best = candidate;
                }
                dpLeft[right] = best;
            }
        }
        return dp[0][m];
    }
}
