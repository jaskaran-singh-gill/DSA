class Solution {
    public int[] singleNumber(int[] nums) {
        int x = 0;
        for (int v : nums) x ^= v;
        int m = x & -x;
        int a = 0, b = 0;
        for (int v : nums) {
            if ((v & m) == 0) a ^= v; else b ^= v;
        }
        return new int[]{a, b};
    }
}
