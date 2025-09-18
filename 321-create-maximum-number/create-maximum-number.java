class Solution {
    private int[] pick(int[] a, int k) {
        int n = a.length, drop = n - k, top = 0;
        int[] st = new int[k];
        for (int x : a) {
            while (top > 0 && st[top - 1] < x && drop > 0) { top--; drop--; }
            if (top < k) st[top++] = x;
            else drop--;
        }
        return st;
    }
    private boolean greater(int[] a, int i, int[] b, int j) {
        int n = a.length, m = b.length;
        while (i < n && j < m && a[i] == b[j]) { i++; j++; }
        return j == m || (i < n && a[i] > b[j]);
    }
    private int[] merge(int[] a, int[] b, int k) {
        int i = 0, j = 0, t = 0;
        int[] res = new int[k];
        while (t < k) res[t++] = greater(a, i, b, j) ? a[i++] : b[j++];
        return res;
    }
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int l = Math.max(0, k - n), r = Math.min(k, m);
        int[] best = new int[k];
        boolean has = false;
        for (int i = l; i <= r; i++) {
            int[] p1 = pick(nums1, i), p2 = pick(nums2, k - i);
            int[] cand = merge(p1, p2, k);
            if (!has || greater(cand, 0, best, 0)) { best = cand; has = true; }
        }
        return best;
    }
}
