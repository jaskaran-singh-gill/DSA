class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;
        int mn = nums[0], mx = nums[0];
        for (int i = 1; i < n; i++) {
            int x = nums[i];
            if (x < mn) mn = x;
            if (x > mx) mx = x;
        }
        if (mn == mx) return 0;
        int diff = mx - mn;
        int bs = (diff + (n - 2)) / (n - 1);
        int bc = diff / bs + 1;
        int[] bmin = new int[bc], bmax = new int[bc];
        boolean[] used = new boolean[bc];
        for (int x : nums) {
            int idx = (x - mn) / bs;
            if (!used[idx]) {
                used[idx] = true;
                bmin[idx] = x;
                bmax[idx] = x;
            } else {
                if (x < bmin[idx]) bmin[idx] = x;
                if (x > bmax[idx]) bmax[idx] = x;
            }
        }
        int ans = 0, prev = mn;
        for (int i = 0; i < bc; i++) {
            if (!used[i]) continue;
            int gap = bmin[i] - prev;
            if (gap > ans) ans = gap;
            prev = bmax[i];
        }
        return ans;
    }
}
