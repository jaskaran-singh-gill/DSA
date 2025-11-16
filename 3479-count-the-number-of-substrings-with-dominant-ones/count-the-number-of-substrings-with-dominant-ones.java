class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        char[] a = s.toCharArray();
        int[] nxt = new int[n + 1];
        nxt[n] = n;
        for (int i = n - 1; i >= 0; --i) {
            int t = nxt[i + 1];
            if (a[i] == '0') t = i;
            nxt[i] = t;
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int cnt0 = a[i] == '0' ? 1 : 0;
            int j = i;
            while (j < n && 1L * cnt0 * cnt0 <= n) {
                int nextPos = nxt[j + 1];
                int cnt1 = nextPos - i - cnt0;
                if (cnt1 >= cnt0 * cnt0) {
                    int add1 = nextPos - j;
                    int add2 = cnt1 - cnt0 * cnt0 + 1;
                    ans += add1 < add2 ? add1 : add2;
                }
                j = nextPos;
                ++cnt0;
            }
        }
        return ans;
    }
}
