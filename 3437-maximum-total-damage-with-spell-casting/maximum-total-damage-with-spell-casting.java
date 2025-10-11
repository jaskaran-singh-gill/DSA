class Solution {
    public long maximumTotalDamage(int[] power) {
        int n = power.length;
        java.util.Arrays.sort(power);
        int[] vals = new int[n];
        long[] sums = new long[n];
        int m = 0;
        for (int i = 0; i < n; ) {
            int v = power[i], j = i + 1;
            while (j < n && power[j] == v) j++;
            vals[m] = v;
            sums[m] = (long) v * (j - i);
            m++;
            i = j;
        }
        long[] dp = new long[m];
        int j = -1;
        for (int i = 0; i < m; i++) {
            while (j + 1 < i && vals[i] - vals[j + 1] > 2) j++;
            long take = sums[i] + (j >= 0 ? dp[j] : 0);
            long skip = i > 0 ? dp[i - 1] : 0;
            dp[i] = take > skip ? take : skip;
        }
        return dp[m - 1];
    }
}
