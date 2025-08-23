class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0 || s.charAt(0) == '0') return 0;
        int a = 1, b = 1;
        for (int i = 1; i < n; i++) {
            int cur = 0;
            char c = s.charAt(i), p = s.charAt(i - 1);
            if (c != '0') cur += b;
            int v = (p - '0') * 10 + (c - '0');
            if (p != '0' && v <= 26) cur += a;
            if (cur == 0) return 0;
            a = b;
            b = cur;
        }
        return b;
    }
}
