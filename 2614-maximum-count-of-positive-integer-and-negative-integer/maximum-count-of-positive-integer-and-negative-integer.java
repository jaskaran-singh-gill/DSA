class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int neg = lowerBound(nums, 0);
        int pos = n - upperBound(nums, 0);
        return Math.max(neg, pos);
    }
    private int lowerBound(int[] a, int t) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (a[m] < t) l = m + 1;
            else r = m;
        }
        return l;
    }
    private int upperBound(int[] a, int t) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (a[m] <= t) l = m + 1;
            else r = m;
        }
        return l;
    }
}
