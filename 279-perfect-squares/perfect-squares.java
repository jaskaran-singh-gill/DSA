class Solution {
    public int numSquares(int n) {
        while ((n & 3) == 0) n >>= 2;
        if ((n & 7) == 7) return 4;
        if (isSq(n)) return 1;
        for (int a = 1; a * a <= n; a++) if (isSq(n - a * a)) return 2;
        return 3;
    }
    private boolean isSq(int x) {
        int r = (int)Math.sqrt(x);
        return r * r == x;
        }
}
