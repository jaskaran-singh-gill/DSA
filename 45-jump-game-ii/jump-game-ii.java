class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;
        int jumps = 0, end = 0, far = 0;
        for (int i = 0; i < n - 1; i++) {
            int reach = i + nums[i];
            if (reach > far) far = reach;
            if (i == end) {
                jumps++;
                end = far;
                if (end >= n - 1) break;
            }
        }
        return jumps;
    }
}
