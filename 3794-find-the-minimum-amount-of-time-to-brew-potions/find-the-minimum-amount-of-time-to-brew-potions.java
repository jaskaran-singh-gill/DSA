class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length, m = mana.length;
        long[] pre = new long[n + 1];
        for (int i = 0; i < n; i++) pre[i + 1] = pre[i] + skill[i];
        long ans = pre[n] * (long) mana[m - 1];
        for (int j = 0; j < m - 1; j++) {
            long b = mana[j], c = mana[j + 1], diff = b - c, best = Long.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                long v = pre[i] * diff + (long) skill[i] * b;
                if (v > best) best = v;
            }
            ans += best;
        }
        return ans;
    }
}
