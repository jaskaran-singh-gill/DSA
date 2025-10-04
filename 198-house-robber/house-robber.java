class Solution {
    public int rob(int[] nums) {
        int take = 0, skip = 0;
        for (int x : nums) {
            int ntake = skip + x;
            skip = Math.max(skip, take);
            take = ntake;
        }
        return Math.max(take, skip);
    }
}
