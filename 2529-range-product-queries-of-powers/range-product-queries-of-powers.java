
public class Solution {
    static final long MOD = 1_000_000_007L;

    public int[] productQueries(int n, int[][] queries) {
        // Step 1: collect exponents of set bits
        List<Integer> exps = new ArrayList<>();
        int bitPos = 0;
        int x = n;
        while (x > 0) {
            if ((x & 1) == 1) {
                exps.add(bitPos);
            }
            bitPos++;
            x >>= 1;
        }

        // Step 2: prefix sums of exponents
        long[] prefix = new long[exps.size() + 1];
        for (int i = 0; i < exps.size(); i++) {
            prefix[i + 1] = prefix[i] + exps.get(i);
        }

        // Step 3: answer queries
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            long sumExp = prefix[r + 1] - prefix[l];
            ans[i] = modPow(2, sumExp, MOD);
        }

        return ans;
    }

    // Fast modular exponentiation
    private int modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return (int) result;
    }
}
