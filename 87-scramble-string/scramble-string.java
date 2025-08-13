class Solution {
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        if (n != s2.length()) return false;
        if (s1.equals(s2)) return true;
        char[] a = s1.toCharArray(), b = s2.toCharArray();
        int[][] pre1 = new int[26][n + 1], pre2 = new int[26][n + 1];
        for (int i = 0; i < n; i++) {
            int c1 = a[i] - 'a', c2 = b[i] - 'a';
            for (int c = 0; c < 26; c++) {
                pre1[c][i + 1] = pre1[c][i];
                pre2[c][i + 1] = pre2[c][i];
            }
            pre1[c1][i + 1]++;
            pre2[c2][i + 1]++;
        }
        byte[][][] memo = new byte[n][n][n + 1];
        return dfs(a, b, 0, 0, n, pre1, pre2, memo);
    }
    private boolean dfs(char[] a, char[] b, int i, int j, int len, int[][] pre1, int[][] pre2, byte[][][] memo) {
        if (memo[i][j][len] != 0) return memo[i][j][len] == 1;
        if (regionMatches(a, b, i, j, len)) {
            memo[i][j][len] = 1;
            return true;
        }
        if (!sameCounts(pre1, pre2, i, j, len)) {
            memo[i][j][len] = 2;
            return false;
        }
        for (int k = 1; k < len; k++) {
            if (dfs(a, b, i, j, k, pre1, pre2, memo) && dfs(a, b, i + k, j + k, len - k, pre1, pre2, memo)) {
                memo[i][j][len] = 1;
                return true;
            }
            if (dfs(a, b, i, j + len - k, k, pre1, pre2, memo) && dfs(a, b, i + k, j, len - k, pre1, pre2, memo)) {
                memo[i][j][len] = 1;
                return true;
            }
        }
        memo[i][j][len] = 2;
        return false;
    }
    private boolean regionMatches(char[] a, char[] b, int i, int j, int len) {
        for (int t = 0; t < len; t++) if (a[i + t] != b[j + t]) return false;
        return true;
    }
    private boolean sameCounts(int[][] pre1, int[][] pre2, int i, int j, int len) {
        int ie = i + len, je = j + len;
        for (int c = 0; c < 26; c++) if (pre1[c][ie] - pre1[c][i] != pre2[c][je] - pre2[c][j]) return false;
        return true;
    }
}

