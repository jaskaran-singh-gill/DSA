class Solution {
    public int maximumCandies(int[] candies, long k) {
        int max = 0;
        for (int c : candies) if (c > max) max = c;
        int l = 1, r = max, ans = 0;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (can(candies, k, mid)) {
                ans = mid;
                l = mid + 1;
            } else r = mid - 1;
        }
        return ans;
    }
    private boolean can(int[] candies, long k, int x) {
        if (x == 0) return true;
        long cnt = 0;
        for (int c : candies) {
            cnt += c / x;
            if (cnt >= k) return true;
        }
        return false;
    }
}
