class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] cnt = new int[value];
        for (int x : nums) {
            int r = x % value;
            if (r < 0) r += value;
            cnt[r]++;
        }
        int mex = 0;
        while (true) {
            int r = mex % value;
            if (cnt[r] == 0) return mex;
            cnt[r]--;
            mex++;
        }
    }
}
