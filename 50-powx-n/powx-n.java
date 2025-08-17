class Solution {
    public double myPow(double x, int n) {
        long p = n;
        if (p < 0) {
            x = 1 / x;
            p = -p;
        }
        double res = 1.0;
        while (p > 0) {
            if ((p & 1) == 1) res *= x;
            x *= x;
            p >>= 1;
        }
        return res;
    }
}
