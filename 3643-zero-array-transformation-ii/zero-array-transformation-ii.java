class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length, m = queries.length;
        int l = 0, r = m, ans = -1;
        long[] diff = new long[n + 1];
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (check(nums, queries, mid, diff)) {
                ans = mid;
                r = mid - 1;
            } else l = mid + 1;
        }
        return ans == -1 ? -1 : ans;
    }
    private boolean check(int[] nums, int[][] q, int k, long[] diff) {
        int n = nums.length;
        java.util.Arrays.fill(diff, 0, n + 1, 0L);
        for (int i = 0; i < k; i++) {
            diff[q[i][0]] += q[i][2];
            int r = q[i][1] + 1;
            if (r <= n) diff[r] -= q[i][2];
        }
        long cur = 0;
        for (int i = 0; i < n; i++) {
            cur += diff[i];
            if (nums[i] > cur) return false;
        }
        return true;
    }
}
