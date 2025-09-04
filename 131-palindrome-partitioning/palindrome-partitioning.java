class Solution {
    List<List<String>> res;
    ArrayList<String> path;
    char[] a;
    boolean[][] pal;
    int n;
    public List<List<String>> partition(String s) {
        n = s.length();
        res = new ArrayList<>();
        path = new ArrayList<>(n);
        a = s.toCharArray();
        pal = new boolean[n][n];
        for (int i = 0; i < n; i++) pal[i][i] = true;
        for (int i = 0; i + 1 < n; i++) pal[i][i + 1] = a[i] == a[i + 1];
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                pal[i][j] = a[i] == a[j] && pal[i + 1][j - 1];
            }
        }
        dfs(0);
        return res;
    }
    void dfs(int i) {
        if (i == n) { res.add(new ArrayList<>(path)); return; }
        for (int j = i; j < n; j++) {
            if (pal[i][j]) {
                path.add(new String(a, i, j - i + 1));
                dfs(j + 1);
                path.remove(path.size() - 1);
            }
        }
    }
}
