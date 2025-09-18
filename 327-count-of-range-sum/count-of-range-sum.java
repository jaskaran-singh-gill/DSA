class Solution {
    long L, U;
    public int countRangeSum(int[] nums, int lower, int upper) {
        L = lower; U = upper;
        int n = nums.length;
        long[] pre = new long[n + 1];
        for (int i = 0; i < n; i++) pre[i + 1] = pre[i] + nums[i];
        long[] buf = new long[n + 1];
        return (int) dc(pre, buf, 0, n + 1);
    }
    private long dc(long[] a, long[] b, int l, int r) {
        if (r - l <= 1) return 0;
        int m = (l + r) >>> 1;
        long cnt = dc(a, b, l, m) + dc(a, b, m, r);
        int i = l, j = m, p = m, q = m, k = l;
        for (; i < m; i++) {
            while (p < r && a[p] - a[i] < L) p++;
            while (q < r && a[q] - a[i] <= U) q++;
            cnt += q - p;
        }
        i = l; j = m;
        while (i < m && j < r) b[k++] = a[i] <= a[j] ? a[i++] : a[j++];
        while (i < m) b[k++] = a[i++];
        while (j < r) b[k++] = a[j++];
        System.arraycopy(b, l, a, l, r - l);
        return cnt;
    }
}
