import java.util.*;

class Solution {
    public int findRotateSteps(String ring, String key) {
        int m = ring.length(), n = key.length();
        ArrayList<Integer>[] pos = new ArrayList[26];
        for (int i = 0; i < 26; i++) pos[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) pos[ring.charAt(i) - 'a'].add(i);
        final int INF = 1 << 29;
        int[] dp = new int[m];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int[] ndp = new int[m];
            Arrays.fill(ndp, INF);
            for (int p : pos[key.charAt(i) - 'a']) {
                for (int q = 0; q < m; q++) {
                    int cur = dp[q];
                    if (cur == INF) continue;
                    int d = Math.abs(p - q);
                    int step = d < m - d ? d : m - d;
                    int val = cur + step + 1;
                    if (val < ndp[p]) ndp[p] = val;
                }
            }
            dp = ndp;
        }
        int ans = INF;
        for (int v : dp) if (v < ans) ans = v;
        return ans;
    }
}
