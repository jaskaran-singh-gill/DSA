class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length, reach = 0;
        for (int i = 0; i <= reach && reach < n - 1; i++) {
            int r = i + nums[i];
            if (r > reach) reach = r;
        }
        return reach >= n - 1;
    }
}
