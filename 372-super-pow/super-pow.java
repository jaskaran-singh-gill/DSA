class Solution {
    private int pow(int a, int e, int mod) {
        long x = a % mod, r = 1;
        while (e > 0) {
            if ((e & 1) != 0) r = (r * x) % mod;
            x = (x * x) % mod;
            e >>= 1;
        }
        return (int) r;
    }

    public int superPow(int a, int[] b) {
        int mod = 1337, res = 1, base = a % mod;
        for (int d : b) {
            res = (int)((long)pow(res, 10, mod) * pow(base, d, mod) % mod);
        }
        return res;
    }
}
