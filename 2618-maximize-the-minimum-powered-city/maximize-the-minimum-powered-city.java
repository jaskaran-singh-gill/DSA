class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length, w = 2 * r + 1;
        long[] base = new long[n];
        long cur = 0;
        for (int i = 0; i < Math.min(n, r); i++) cur += stations[i];
        for (int i = 0; i <= Math.min(n - 1, r); i++) cur += stations[i];
        for (int i = 0; i < n; i++) {
            int L = Math.max(0, i - r), R = Math.min(n - 1, i + r);
            if (i == 0) {
                long s = 0;
                for (int j = L; j <= R; j++) s += stations[j];
                base[i] = s;
            } else {
                int prevL = Math.max(0, i - 1 - r), prevR = Math.min(n - 1, i - 1 + r);
                long s = base[i - 1];
                if (L != prevL) s -= stations[prevL];
                if (R != prevR) s += stations[R];
                base[i] = s;
            }
        }
        long hi = 0;
        for (long v : base) if (v > hi) hi = v;
        hi += k;
        long lo = 0, ans = 0;
        while (lo <= hi) {
            long mid = (lo + hi) >>> 1;
            if (ok(base, stations, r, k, mid)) {
                ans = mid;
                lo = mid + 1;
            } else hi = mid - 1;
        }
        return ans;
    }
    boolean ok(long[] base, int[] stations, int r, long k, long target) {
        int n = stations.length;
        long used = 0, add = 0;
        long[] diff = new long[n + 1];
        for (int i = 0; i < n; i++) {
            add += diff[i];
            long have = base[i] + add;
            if (have < target) {
                long need = target - have;
                used += need;
                if (used > k) return false;
                int pos = Math.min(n - 1, i + r);
                add += need;
                int end = pos + r + 1;
                if (end <= n) diff[end] -= need;
            }
        }
        return true;
    }
}
