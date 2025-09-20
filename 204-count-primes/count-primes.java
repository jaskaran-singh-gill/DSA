class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        int m = (n - 2) >> 1, cnt = m;
        boolean[] c = new boolean[m];
        for (int i = 0; i < m; i++) {
            int p = (i << 1) + 3;
            long pp = (long)p * p;
            if (pp >= n) break;
            if (c[i]) continue;
            int start = (int)((pp - 3) >> 1);
            for (int j = start; j < m; j += p) {
                if (!c[j]) { c[j] = true; cnt--; }
            }
        }
        return cnt + 1;
    }
}
