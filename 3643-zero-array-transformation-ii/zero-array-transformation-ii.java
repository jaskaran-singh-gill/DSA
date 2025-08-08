class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length, m = queries.length;
        int l = 0, r = m, ans = -1;
        long[] diff = new long[n + 1];
        int[] seen = new int[n + 1];
        int version = 0;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            version++;
            if (check(nums, queries, mid, diff, seen, version)) {
                ans = mid;
                r = mid - 1;
            } else l = mid + 1;
        }
        return ans == -1 ? -1 : ans;
    }
    private boolean check(int[] nums, int[][] q, int k, long[] diff, int[] seen, int ver) {
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            int L = q[i][0], R = q[i][1] + 1, v = q[i][2];
            if (seen[L] != ver) { seen[L] = ver; diff[L] = 0; }
            diff[L] += v;
            if (R <= n) {
                if (seen[R] != ver) { seen[R] = ver; diff[R] = 0; }
                diff[R] -= v;
            }
        }
        long cur = 0;
        for (int i = 0; i < n; i++) {
            if (seen[i] != ver) { seen[i] = ver; diff[i] = 0; }
            cur += diff[i];
            if (nums[i] > cur) return false;
        }
        return true;
    }
}
