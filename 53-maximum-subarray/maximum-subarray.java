class Solution {
    public int maxSubArray(int[] nums) {
        int best = nums[0], cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            cur = cur < 0 ? x : cur + x;
            if (cur > best) best = cur;
        }
        return best;
    }
}
