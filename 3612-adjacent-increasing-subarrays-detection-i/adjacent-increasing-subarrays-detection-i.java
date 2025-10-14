class Solution {
    public boolean hasIncreasingSubarrays(java.util.List<Integer> nums, int k) {
        int n = nums.size();
        int[] inc = new int[n];
        inc[0] = 1;
        for (int i = 1; i < n; i++) inc[i] = nums.get(i) > nums.get(i - 1) ? inc[i - 1] + 1 : 1;
        for (int s = 0; s + 2 * k <= n; s++) if (inc[s + k - 1] >= k && inc[s + 2 * k - 1] >= k) return true;
        return false;
    }
}
