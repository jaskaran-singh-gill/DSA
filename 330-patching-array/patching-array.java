class Solution {
    public int minPatches(int[] nums, int n) {
        long miss = 1, limit = n;
        int i = 0, ans = 0;
        while (miss <= limit) {
            if (i < nums.length && nums[i] <= miss) miss += nums[i++];
            else { miss += miss; ans++; }
        }
        return ans;
    }
}
