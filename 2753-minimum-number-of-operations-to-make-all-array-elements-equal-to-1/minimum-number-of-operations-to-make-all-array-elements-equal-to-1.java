class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length, ones = 0, g = 0;
        for (int v : nums) {
            if (v == 1) ones++;
            g = gcd(g, v);
        }
        if (ones > 0) return n - ones;
        if (g != 1) return -1;
        int best = n + 1;
        for (int i = 0; i < n && best > 2; i++) {
            int cur = nums[i];
            for (int j = i; j < n; j++) {
                cur = gcd(cur, nums[j]);
                if (cur == 1) {
                    int len = j - i + 1;
                    if (len < best) best = len;
                    break;
                }
            }
        }
        return n + best - 2;
    }
    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
