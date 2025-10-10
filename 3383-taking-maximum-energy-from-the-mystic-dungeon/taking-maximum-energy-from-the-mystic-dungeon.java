class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length, ans = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (i + k < n) energy[i] += energy[i + k];
            if (energy[i] > ans) ans = energy[i];
        }
        return ans;
    }
}
