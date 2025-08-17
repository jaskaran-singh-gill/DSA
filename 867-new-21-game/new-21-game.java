class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0 || n >= k - 1 + maxPts) return 1.0;
        double[] dp = new double[n + 1];
        dp[0] = 1.0;
        double win = 1.0, res = 0.0;
        for (int i = 1; i <= n; i++) {
            dp[i] = win / maxPts;
            if (i < k) win += dp[i];
            else res += dp[i];
            int j = i - maxPts;
            if (j >= 0 && j < k) win -= dp[j];
        }
        return res;
    }
}
