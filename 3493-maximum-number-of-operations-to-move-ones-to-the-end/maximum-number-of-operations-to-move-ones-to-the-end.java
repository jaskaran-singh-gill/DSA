class Solution {
    public int maxOperations(String s) {
        char[] a = s.toCharArray();
        int n = a.length;
        int ones = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            char c = a[i];
            if (c == '1') {
                ones++;
            } else if (i == n - 1 || a[i + 1] == '1') {
                ans += ones;
            }
        }
        return ans;
    }
}
