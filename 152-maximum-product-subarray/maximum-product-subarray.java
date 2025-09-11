class Solution {
    public int maxProduct(int[] nums) {
        int hi = nums[0], lo = nums[0], ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            if (x < 0) { int t = hi; hi = lo; lo = t; }
            int a = hi * x, b = lo * x;
            hi = a > x ? a : x;
            lo = b < x ? b : x;
            if (hi > ans) ans = hi;
        }
        return ans;
    }
}
