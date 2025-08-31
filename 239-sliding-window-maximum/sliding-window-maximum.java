class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) return new int[0];
        int[] res = new int[n - k + 1];
        int[] dq = new int[n];
        int head = 0, tail = 0, ri = 0;
        for (int i = 0; i < n; i++) {
            while (head < tail && dq[head] <= i - k) head++;
            while (head < tail && nums[dq[tail - 1]] <= nums[i]) tail--;
            dq[tail++] = i;
            if (i >= k - 1) res[ri++] = nums[dq[head]];
        }
        return res;
    }
}
