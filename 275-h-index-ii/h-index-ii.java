class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length, l = 0, r = n - 1, ans = 0;
        while (l <= r) {
            int m = (l + r) >>> 1;
            int h = n - m;
            if (citations[m] >= h) { ans = h; r = m - 1; }
            else l = m + 1;
        }
        return ans;
    }
}
