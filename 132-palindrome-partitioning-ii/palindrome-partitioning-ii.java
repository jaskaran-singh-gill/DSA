class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] cut = new int[n];
        for (int i = 0; i < n; i++) cut[i] = i;
        for (int c = 0; c < n; c++) {
            int l = c, r = c;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                cut[r] = Math.min(cut[r], l == 0 ? 0 : cut[l - 1] + 1);
                l--; r++;
            }
            l = c; r = c + 1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                cut[r] = Math.min(cut[r], l == 0 ? 0 : cut[l - 1] + 1);
                l--; r++;
            }
        }
        return cut[n - 1];
    }
}
