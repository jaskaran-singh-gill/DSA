
class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int n = nums.length;
        int minV = Integer.MAX_VALUE, maxV = Integer.MIN_VALUE;
        for (int v : nums) {
            if (v < minV) minV = v;
            if (v > maxV) maxV = v;
        }
        int lo = minV - k;
        int hi = maxV + k;
        int offset = -lo;
        int size = hi - lo + 1;
        int[] diff = new int[size + 2];
        int[] exact = new int[size + 1];
        for (int v : nums) {
            int L = v - k + offset;
            int R = v + k + offset;
            diff[L]++;
            diff[R + 1]--;
            exact[v + offset]++;
        }
        int curr = 0;
        int ans = 0;
        for (int i = 0; i < size; i++) {
            curr += diff[i];
            int reachable = curr;
            int already = exact[i];
            int possible = already + Math.min(numOperations, reachable - already);
            if (possible > ans) ans = possible;
        }
        return ans;
    }
}
