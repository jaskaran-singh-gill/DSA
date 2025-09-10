class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;
        boolean[][] know = new boolean[m + 1][n + 1];
        for (int i = 1; i <= m; i++) for (int x : languages[i - 1]) know[i][x] = true;
        boolean[] bad = new boolean[m + 1];
        int badCnt = 0;
        for (int[] e : friendships) {
            int u = e[0], v = e[1];
            boolean ok = false;
            for (int x : languages[u - 1]) { if (know[v][x]) { ok = true; break; } }
            if (!ok) {
                if (!bad[u]) { bad[u] = true; badCnt++; }
                if (!bad[v]) { bad[v] = true; badCnt++; }
            }
        }
        if (badCnt == 0) return 0;
        int ans = badCnt;
        for (int lang = 1; lang <= n; lang++) {
            int need = 0;
            for (int i = 1; i <= m; i++) if (bad[i] && !know[i][lang]) need++;
            if (need < ans) ans = need;
        }
        return ans;
    }
}
