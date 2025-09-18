
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int r = matrix.length, c = matrix[0].length;
        boolean swap = r > c;
        int R = swap ? c : r, C = swap ? r : c;
        int[][] a = matrix;
        int ans = Integer.MIN_VALUE;
        int[] sums = new int[C];
        for (int top = 0; top < R; top++) {
            Arrays.fill(sums, 0);
            for (int bottom = top; bottom < R; bottom++) {
                if (!swap) {
                    for (int j = 0; j < C; j++) sums[j] += a[bottom][j];
                } else {
                    for (int j = 0; j < C; j++) sums[j] += a[j][bottom];
                }
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                int pref = 0;
                for (int v : sums) {
                    pref += v;
                    Integer x = set.ceiling(pref - k);
                    if (x != null) {
                        int cand = pref - x;
                        if (cand > ans) ans = cand;
                        if (ans == k) return k;
                    }
                    set.add(pref);
                }
            }
        }
        return ans;
    }
}
