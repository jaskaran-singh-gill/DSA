import java.util.*;

class Solution {
    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
        long diag = 0;
        for (int i = 0; i < n; i++) {
            diag += fruits[i][i];
            fruits[i][i] = 0;
        }
        final int NEG = -1_000_000_000;

        int[] dpB = new int[n];
        Arrays.fill(dpB, NEG);
        dpB[n - 1] = fruits[0][n - 1];
        for (int r = 1; r < n; r++) {
            int[] ndp = new int[n];
            Arrays.fill(ndp, NEG);
            int up = Math.min(n - 1, n - 1 + r);          // reachable range optimisation (optional)
            int low = Math.max(0, n - 1 - r);
            for (int c = low; c <= up; c++) {
                int best = dpB[c];
                if (c > 0) best = Math.max(best, dpB[c - 1]);
                if (c + 1 < n) best = Math.max(best, dpB[c + 1]);
                if (best != NEG) ndp[c] = best + fruits[r][c];
            }
            dpB = ndp;
        }
        int bestB = dpB[n - 1];

        int[] dpC = new int[n];
        Arrays.fill(dpC, NEG);
        dpC[n - 1] = fruits[n - 1][0];
        for (int c = 1; c < n; c++) {
            int[] ndp = new int[n];
            Arrays.fill(ndp, NEG);
            int up = Math.min(n - 1 + c, n - 1);
            int low = Math.max(0, n - 1 - c);
            for (int r = low; r <= up; r++) {
                int best = dpC[r];
                if (r > 0) best = Math.max(best, dpC[r - 1]);
                if (r + 1 < n) best = Math.max(best, dpC[r + 1]);
                if (best != NEG) ndp[r] = best + fruits[r][c];
            }
            dpC = ndp;
        }
        int bestC = dpC[n - 1];

        long res = diag + bestB + bestC;
        return (int) res;
    }
}
