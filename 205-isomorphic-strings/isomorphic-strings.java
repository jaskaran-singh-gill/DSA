class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        int[] a = new int[256], b = new int[256];
        for (int i = 0; i < n; i++) {
            int x = s.charAt(i) & 255, y = t.charAt(i) & 255;
            if (a[x] != b[y]) return false;
            a[x] = i + 1;
            b[y] = i + 1;
        }
        return true;
    }
}
