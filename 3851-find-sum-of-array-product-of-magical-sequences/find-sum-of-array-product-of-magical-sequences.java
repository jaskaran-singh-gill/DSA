class Solution {
    public int magicalSum(int m, int k, int[] nums) {
        int n = nums.length, MOD = 1000000007;
        int[][] comb = new int[m + 1][m + 1];
        for (int i = 0; i <= m; i++) {
            comb[i][0] = 1;
            for (int j = 1; j <= i; j++) comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
        }
        int[][][] dp = new int[m + 1][m + 1][k + 1];
        dp[0][0][0] = 1;
        for (int i = 0; i < n; i++) {
            int[] pow = new int[m + 1];
            pow[0] = 1;
            long base = nums[i] % MOD;
            for (int c = 1; c <= m; c++) pow[c] = (int)(pow[c - 1] * base % MOD);
            int[][][] ndp = new int[m + 1][m + 1][k + 1];
            for (int used = 0; used <= m; used++) {
                int rem = m - used;
                for (int carry = 0; carry <= m; carry++) {
                    for (int bits = 0; bits <= k; bits++) {
                        int val = dp[used][carry][bits];
                        if (val == 0) continue;
                        for (int c = 0; c <= rem; c++) {
                            int nc = (carry + c) >>> 1;
                            int nb = bits + ((carry + c) & 1);
                            if (nb > k) continue;
                            int add = (int)((long)val * comb[rem][c] % MOD);
                            add = (int)((long)add * pow[c] % MOD);
                            int u2 = used + c;
                            int cur = ndp[u2][nc][nb] + add;
                            ndp[u2][nc][nb] = cur >= MOD ? cur - MOD : cur;
                        }
                    }
                }
            }
            dp = ndp;
        }
        long ans = 0;
        for (int carry = 0; carry <= m; carry++) {
            int pc = Integer.bitCount(carry);
            for (int bits = 0; bits <= k; bits++) {
                if (bits + pc == k) ans += dp[m][carry][bits];
            }
        }
        return (int)(ans % 1000000007);
    }
}
