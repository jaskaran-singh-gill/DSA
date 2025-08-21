class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean fr = false, fc = false;
        for (int j = 0; j < n; j++) if (matrix[0][j] == 0) { fr = true; break; }
        for (int i = 0; i < m; i++) if (matrix[i][0] == 0) { fc = true; break; }
        for (int i = 1; i < m; i++) {
            int[] row = matrix[i];
            for (int j = 1; j < n; j++) if (row[j] == 0) { row[0] = 0; matrix[0][j] = 0; }
        }
        for (int i = 1; i < m; i++) if (matrix[i][0] == 0) java.util.Arrays.fill(matrix[i], 0);
        for (int j = 1; j < n; j++) if (matrix[0][j] == 0) for (int i = 1; i < m; i++) matrix[i][j] = 0;
        if (fr) java.util.Arrays.fill(matrix[0], 0);
        if (fc) for (int i = 0; i < m; i++) matrix[i][0] = 0;
    }
}
