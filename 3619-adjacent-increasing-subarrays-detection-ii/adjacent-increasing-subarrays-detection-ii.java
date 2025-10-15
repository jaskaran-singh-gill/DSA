class Solution {
    public int maxIncreasingSubarrays(java.util.List<Integer> nums) {
        int n = nums.size();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = nums.get(i);
        int[] inc = new int[n];
        inc[0] = 1;
        for (int i = 1; i < n; i++) inc[i] = a[i] > a[i - 1] ? inc[i - 1] + 1 : 1;
        int l = 1, r = n / 2, ans = 0;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            boolean ok = false;
            int limit = n - 2 * mid;
            for (int s = 0; s <= limit; s++) {
                if (inc[s + mid - 1] >= mid && inc[s + 2 * mid - 1] >= mid) { ok = true; break; }
            }
            if (ok) { ans = mid; l = mid + 1; } else r = mid - 1;
        }
        return ans;
    }
}
