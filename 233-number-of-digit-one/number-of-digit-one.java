class Solution {
    public int countDigitOne(int n) {
        if (n <= 0) return 0;
        long nl = n, m = 1, res = 0;
        while (m <= nl) {
            long m10 = m * 10;
            long high = nl / m10;
            long cur = (nl / m) - high * 10;
            res += high * m;
            if (cur == 1) res += (nl % m) + 1;
            else if (cur > 1) res += m;
            m = m10;
        }
        return (int) res;
    }
}
