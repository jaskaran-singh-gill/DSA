class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length, ans = 0, top = 0;
        int[] st = new int[n + 1];
        st[0] = 0;
        for (int v : nums) {
            while (top > 0 && st[top] > v) top--;
            if (st[top] < v) {
                if (v != 0) {
                    ans++;
                    st[++top] = v;
                }
            }
        }
        return ans;
    }
}
