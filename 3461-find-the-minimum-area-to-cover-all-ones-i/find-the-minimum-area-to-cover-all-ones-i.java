class Solution {
    public int minimumArea(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int minR = n, minC = m, maxR = -1, maxC = -1;
        for (int i = 0; i < n; i++) {
            int[] row = grid[i];
            for (int j = 0; j < m; j++) {
                if (row[j] == 1) {
                    if (i < minR) minR = i;
                    if (i > maxR) maxR = i;
                    if (j < minC) minC = j;
                    if (j > maxC) maxC = j;
                }
            }
        }
        return (maxR - minR + 1) * (maxC - minC + 1);
    }
}
