class Solution {
    static final int MAXK = 15;
    static final int[] p = new int[MAXK + 1];
    static final long[] pref = new long[MAXK + 1];
    static {
        p[0] = 1;
        for (int i = 1; i <= MAXK; i++) p[i] = p[i - 1] << 2;
        for (int k = 0; k < MAXK; k++) pref[k + 1] = pref[k] + 3L * (k + 1) * p[k];
    }
    private int idx(int n){
        return (31 - Integer.numberOfLeadingZeros(n)) >> 1;
    }
    private long g(int n){
        if (n <= 0) return 0L;
        int k = idx(n);
        return pref[k] + (long)(k + 1) * (n - p[k] + 1L);
    }
    public long minOperations(int[][] queries) {
        long ans = 0L;
        for (int[] q : queries) {
            int l = q[0], r = q[1];
            long S = g(r) - g(l - 1);
            long M = idx(r) + 1L;
            long ops = (S + 1) >> 1;
            if (M > ops) ops = M;
            ans += ops;
        }
        return ans;
    }
}
