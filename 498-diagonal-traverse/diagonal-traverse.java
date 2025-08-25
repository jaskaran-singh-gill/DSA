class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length, len = m * n;
        int[] res = new int[len];
        int r = 0, c = 0, d = 1, i = 0;
        while (i < len) {
            res[i++] = mat[r][c];
            if (d == 1) {
                if (c == n - 1) { r++; d = -1; }
                else if (r == 0) { c++; d = -1; }
                else { r--; c++; }
            } else {
                if (r == m - 1) { c++; d = 1; }
                else if (c == 0) { r++; d = 1; }
                else { r++; c--; }
            }
        }
        return res;
    }
}
