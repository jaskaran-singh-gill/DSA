class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] f = new int[101];
        int mx = 0;
        for (int x : nums) {
            int v = ++f[x];
            if (v > mx) mx = v;
        }
        int ans = 0;
        for (int v : f) if (v == mx) ans += v;
        return ans;
    }
}
