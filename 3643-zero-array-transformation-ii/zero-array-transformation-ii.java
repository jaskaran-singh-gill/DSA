class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length, m = queries.length;
        int l = 0, r = m, ans = -1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (check(nums, queries, mid)) {
                ans = mid;
                r = mid - 1;
            } else l = mid + 1;
        }
        return ans == -1 ? -1 : ans;
    }
    private boolean check(int[] nums, int[][] q, int k) {
        int n = nums.length;
        long[] diff = new long[n + 1];
        for (int i = 0; i < k; i++) {
            diff[q[i][0]] += q[i][2];
            diff[q[i][1] + 1] -= q[i][2];
        }
        long cur = 0;
        for (int i = 0; i < n; i++) {
            cur += diff[i];
            if (nums[i] > cur) return false;
        }
        return true;
    }
}
