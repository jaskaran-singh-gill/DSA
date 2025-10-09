import java.util.*;

class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        if (n < 2 || stones[1] != 1) return false;
        for (int i = 2; i < n; i++) if (stones[i] - stones[i - 1] > i) return false;
        HashMap<Integer, Integer> idx = new HashMap<>(n * 2);
        for (int i = 0; i < n; i++) idx.put(stones[i], i);
        boolean[][] dp = new boolean[n][n + 1];
        dp[0][0] = true;
        for (int i = 0; i < n; i++) {
            for (int k = 0; k <= n; k++) {
                if (!dp[i][k]) continue;
                for (int s = k - 1; s <= k + 1; s++) {
                    if (s <= 0) continue;
                    int nextPos = stones[i] + s;
                    Integer j = idx.get(nextPos);
                    if (j == null) continue;
                    if (j == n - 1) return true;
                    dp[j][s] = true;
                }
            }
        }
        return false;
    }
}
