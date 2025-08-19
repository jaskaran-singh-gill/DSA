class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long res = 0, run = 0;
        for (int v : nums) {
            if (v == 0) {
                run++;
                res += run;
            } else run = 0;
        }
        return res;
    }
}
