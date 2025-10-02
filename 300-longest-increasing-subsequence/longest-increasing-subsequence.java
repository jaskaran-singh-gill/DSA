class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length, len = 0;
        int[] tails = new int[n];
        for (int x : nums) {
            int l = 0, r = len;
            while (l < r) {
                int m = (l + r) >>> 1;
                if (tails[m] < x) l = m + 1; else r = m;
            }
            tails[l] = x;
            if (l == len) len++;
        }
        return len;
    }
}
