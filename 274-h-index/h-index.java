class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length, h = 0;
        int[] cnt = new int[n + 1];
        for (int c : citations) cnt[Math.min(c, n)]++;
        for (int i = n; i >= 0; i--) {
            h += cnt[i];
            if (h >= i) return i;
        }
        return 0;
    }
}
