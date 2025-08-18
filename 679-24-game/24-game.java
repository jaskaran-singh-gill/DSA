class Solution {
    static final double TARGET = 24.0, EPS = 1e-6;
    public boolean judgePoint24(int[] cards) {
        double[] a = new double[4];
        for (int i = 0; i < 4; i++) a[i] = cards[i];
        return dfs(a, 4);
    }
    private boolean dfs(double[] a, int n) {
        if (n == 1) return Math.abs(a[0] - TARGET) < EPS;
        double[] b = new double[n - 1];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int idx = 0;
                for (int k = 0; k < n; k++) if (k != i && k != j) b[idx++] = a[k];
                double x = a[i], y = a[j];
                b[idx] = x + y;
                if (dfs(b, n - 1)) return true;
                b[idx] = x * y;
                if (dfs(b, n - 1)) return true;
                b[idx] = x - y;
                if (dfs(b, n - 1)) return true;
                b[idx] = y - x;
                if (dfs(b, n - 1)) return true;
                if (Math.abs(y) > EPS) {
                    b[idx] = x / y;
                    if (dfs(b, n - 1)) return true;
                }
                if (Math.abs(x) > EPS) {
                    b[idx] = y / x;
                    if (dfs(b, n - 1)) return true;
                }
            }
        }
        return false;
    }
}
